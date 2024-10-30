package kelmerdev.com.controller;

import kelmerdev.com.dto.BookDTO;
import kelmerdev.com.model.Book;
import kelmerdev.com.service.BookService;
import lombok.AllArgsConstructor;
import lombok.Generated;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class Bookcontroller {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> findAll() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody BookDTO bookDTO){
        Book book = bookService.create(bookDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@RequestBody BookDTO bookDTO, @PathVariable Long id){
        Book book = bookService.update(bookDTO, id);
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        bookService.delete(id);
    }
}
