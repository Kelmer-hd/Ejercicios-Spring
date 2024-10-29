package kelmerdev.com.mapper;

import kelmerdev.com.dto.PrestamoResponse;
import kelmerdev.com.model.Prestamo;
import org.springframework.stereotype.Component;

@Component
public class PrestamoMapper {

    public PrestamoResponse toPrestamoResponse(Prestamo prestamo) {
        PrestamoResponse response = new PrestamoResponse();
        response.setId(prestamo.getId());
        response.setTitulo(prestamo.getLibro().getTitle());
        response.setNombreUsuario(prestamo.getUsuario().getName());
        response.setFechaPrestamo(prestamo.getFechaPrestamo());
        response.setFechaDevolucionEsperada(prestamo.getFechaDevolucionEsperada());
        response.setStatus(prestamo.getStatus().name());
        return response;
    }
}