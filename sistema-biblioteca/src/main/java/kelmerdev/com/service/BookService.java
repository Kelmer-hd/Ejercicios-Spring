package kelmerdev.com.service;

import kelmerdev.com.dto.BookDTO;
import kelmerdev.com.entity.Book;

public interface BookService {

    // Crear Un libro
    Book create(BookDTO bookDTO);

    // Actualizar un Libro
    BookDTO update(Long id, BookDTO bookDTO);

    // Eliminar un Libro
    void delete(Long id);

}
