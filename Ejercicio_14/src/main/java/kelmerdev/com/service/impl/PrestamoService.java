package kelmerdev.com.service.impl;

import kelmerdev.com.dto.PrestamoRequest;
import kelmerdev.com.dto.PrestamoResponse;
import kelmerdev.com.exception.BadRequestException;
import kelmerdev.com.exception.ResourceNotFoundException;
import kelmerdev.com.mapper.PrestamoMapper;
import kelmerdev.com.model.*;
import kelmerdev.com.repository.LibroRepository;
import kelmerdev.com.repository.PrestamosRepository;
import kelmerdev.com.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PrestamoService {

    private PrestamosRepository prestamosRepository;
    private LibroRepository libroRepository;
    private UserRepository userRepository;
    private final PrestamoMapper prestamoMapper;

    @Transactional
    public PrestamoResponse createPrestamo(PrestamoRequest resquest) {
        // Buscar libor y usuario
        Libro libro = libroRepository.findById(resquest.getLibroId())
                .orElseThrow(() -> new ResourceNotFoundException("Libro not found"));

        User user = userRepository.findById(resquest.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario not found"));

        // Validar disponibilidad del libro
        if (libro.getCopiesAvailable() <= 0) {
            throw new BadRequestException("No hay copias disponibles de este libro");
        }

        // Validar el limite de prestamos del usuario
        long prestamosActivos = prestamosRepository.countByUsuarioAndStatus(user, StatusPrestamo.ACTIVO);
        if (prestamosActivos >= 3) {
            throw new BadRequestException("El usuario ya tiene el máximo de préstamos permitidos (3)");
        }

        // Crear el prestamo
        Prestamo prestamo = new Prestamo();
        prestamo.setLibro(libro);
        prestamo.setUsuario(user);
        prestamo.setFechaPrestamo(LocalDateTime.now());
        prestamo.setFechaDevolucionEsperada(LocalDateTime.now().plusDays(14));
        prestamo.setStatus(StatusPrestamo.ACTIVO);

        // Actualizar disponibilidad del libro
        libro.setCopiesAvailable(libro.getCopiesAvailable() - 1);
        libro.setStatus(libro.getCopiesAvailable() == 0 ? StatusLibro.PRESTADO : libro.getStatus());
        libroRepository.save(libro);

        // Guardar el préstamo
        prestamo = prestamosRepository.save(prestamo);
        return prestamoMapper.toPrestamoResponse(prestamo);

    }

    @Transactional
    public PrestamoResponse devolverLibro(Long prestamoId) {
        Prestamo prestamo = prestamosRepository.findById(prestamoId)
                .orElseThrow(() -> new ResourceNotFoundException("Préstamo no encontrado"));

        if (prestamo.getStatus() == StatusPrestamo.DEVUELTO) {
            throw new BadRequestException("Este libro ya fue devuelto");
        }

        // Actualizar el préstamo
        prestamo.setStatus(StatusPrestamo.DEVUELTO);

        // Actualizar disponibilidad del libro
        Libro libro = prestamo.getLibro();
        libro.setCopiesAvailable(libro.getCopiesAvailable() + 1);
        libro.setStatus(StatusLibro.DISPONIBLE);
        libroRepository.save(libro);

        prestamo = prestamosRepository.save(prestamo);
        return prestamoMapper.toPrestamoResponse(prestamo);
    }

    public List<PrestamoResponse> obtenerPrestamosPorUsuario(Long usuarioId) {
        if (!userRepository.existsById(usuarioId)) {
            throw new ResourceNotFoundException("Usuario no encontrado");
        }

        return prestamosRepository.findByUsuarioId(usuarioId).stream()
                .map(prestamoMapper::toPrestamoResponse)
                .collect(Collectors.toList());
    }
}
