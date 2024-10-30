package kelmerdev.com.service;

import kelmerdev.com.dto.BookDTO;
import kelmerdev.com.model.Book;
import kelmerdev.com.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }

    // Usanso Builder para crear un nuevo objeto Book

    /*public Book create(BookDTO bookDTO){
        Book bookFromDTO = Book.builder()
                .title(bookDTO.getTitle())
                .author(bookDTO.getAuthor())
                .isbn(bookDTO.getIsbn())
                .year(bookDTO.getYear())
                .build();
        return bookRepository.save(bookFromDTO);
    }
     */

    public Book create(BookDTO bookDTO){
        Book bookFromDTo = new Book();
        bookFromDTo.setTitle(bookDTO.getTitle());
        bookFromDTo.setAuthor(bookDTO.getAuthor());
        bookFromDTo.setIsbn(bookDTO.getIsbn());
        bookFromDTo.setPublisedYear(bookDTO.getPublisedYear());
        return bookRepository.save(bookFromDTo);

    }

    public Book update(BookDTO bookDTO, Long id){
        Book bookFromDTO = findById(id);
        bookFromDTO.setTitle(bookDTO.getTitle());
        bookFromDTO.setAuthor(bookDTO.getAuthor());
        bookFromDTO.setIsbn(bookDTO.getIsbn());
        bookFromDTO.setPublisedYear(bookDTO.getPublisedYear());
        return bookRepository.save(bookFromDTO);
    }

    public void delete(Long id){
        Book book = findById(id);
        bookRepository.deleteById(book.getId());
    }



}
