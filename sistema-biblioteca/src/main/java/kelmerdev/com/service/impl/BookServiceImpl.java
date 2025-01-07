package kelmerdev.com.service.impl;

import kelmerdev.com.dto.BookDTO;
import kelmerdev.com.entity.Book;
import kelmerdev.com.entity.Category;
import kelmerdev.com.repository.BookRepository;
import kelmerdev.com.repository.CategoryRepository;
import kelmerdev.com.service.BookService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private ModelMapper modelMapper;
    private CategoryRepository categoryRepository;

    @Override
    public Book create(BookDTO bookDTO) {

        // Verificamos que las categorías existan
        List<Category> categories = categoryRepository.findAllById(bookDTO.getCategoryIds());
        if (categories.size() != bookDTO.getCategoryIds().size()) {
            throw new RuntimeException("Una o más categorías no existen");
        }

        // El modelMapper.map recibe primero el objeto fuente y luego la clase destino
        Book book = modelMapper.map(bookDTO, Book.class);

        // Asignamos las categorías al libro
        book.setCategories(categories);

        return bookRepository.save(book);

    }

    @Override
    public BookDTO update(Long id, BookDTO bookDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
