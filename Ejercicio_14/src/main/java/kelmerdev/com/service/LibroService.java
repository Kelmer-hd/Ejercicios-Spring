package kelmerdev.com.service;

import kelmerdev.com.dto.LibroRequest;
import kelmerdev.com.dto.LibroResponse;

import java.util.List;

public interface LibroService {

    LibroResponse createLibro(LibroRequest request);

    LibroResponse updateLibro(Long id, LibroRequest request);

    void deleteLibro(Long id);

    LibroResponse getLibroById(Long id);

    List<LibroResponse> getAllLibros();

}
