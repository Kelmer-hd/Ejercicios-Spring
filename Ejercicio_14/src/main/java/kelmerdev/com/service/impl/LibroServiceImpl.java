package kelmerdev.com.service.impl;

import kelmerdev.com.dto.LibroRequest;
import kelmerdev.com.dto.LibroResponse;
import kelmerdev.com.exception.BadRequestException;
import kelmerdev.com.exception.ResourceNotFoundException;
import kelmerdev.com.mapper.LibroMapper;
import kelmerdev.com.model.Libro;
import kelmerdev.com.model.StatusLibro;
import kelmerdev.com.repository.LibroRepository;
import kelmerdev.com.service.LibroService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LibroServiceImpl implements LibroService {

    private LibroRepository libroRepository;

    private LibroMapper libroMapper;


    @Override
    public LibroResponse createLibro(LibroRequest request) {

        if (libroRepository.existsByIsbn(request.getIsbn())) {
            throw new BadRequestException("El libro con ISBN " + request.getIsbn() + " ya existe");
        }

        // Si el ISBN no existe, procedemos a crear el libro
        Libro libro = libroMapper.libroRequestToLibro(request);

        // Asegurmas que tenfa un estado por defecto

        if (libro.getStatus() == null){
            libro.setStatus(StatusLibro.DISPONIBLE);
        }

        // Guardamos el libro
        libro = libroRepository.save(libro);
        return libroMapper.libroToLibroResponse(libro);

    }

    @Override
    public LibroResponse updateLibro(Long id, LibroRequest request) {
        Libro libro = libroRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Libro not found"));

        libro.setIsbn(request.getIsbn());
        libro.setTitle(request.getTitle());
        libro.setAuthor(request.getAuthor());
        libro.setYearPublished(request.getYearPublished());
        libro.setCopiesAvailable(request.getCopiesAvailable());
        libro = libroRepository.save(libro);
        return libroMapper.libroToLibroResponse(libro);
    }

    @Override
    public void deleteLibro(Long id) {
        LibroResponse libro = getLibroById(id);
        libroRepository.deleteById(libro.getId());
    }

    @Override
    public LibroResponse getLibroById(Long id) {
        Libro libro = libroRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Libro not found"));
        return libroMapper.libroToLibroResponse(libro);
    }

    @Override
    public List<LibroResponse> getAllLibros() {
        List<Libro> libros =  libroRepository.findAll();
        return libroMapper.libroListToLibroResponseList(libros);
    }
}
