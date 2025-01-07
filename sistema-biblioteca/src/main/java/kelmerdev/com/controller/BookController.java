package kelmerdev.com.controller;

import jakarta.validation.Valid;
import kelmerdev.com.dto.BookDTO;
import kelmerdev.com.entity.Book;
import kelmerdev.com.service.impl.BookServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/books")
@AllArgsConstructor
public class BookController {

    private BookServiceImpl bookService;

    @PostMapping
    public ResponseEntity<Book> createBook(@Valid @RequestBody BookDTO bookDTO){
        Book book = bookService.create(bookDTO);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }
}
