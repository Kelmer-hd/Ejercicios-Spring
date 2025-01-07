package com.kelmerdev.controller;

import com.kelmerdev.model.Book;
import com.kelmerdev.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Obtener todos lo libros
    @GetMapping
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    // Endpoint para obtener un libro en especifico
    @GetMapping("/{id}")
    public Optional<Book> findById(@PathVariable long id){
        return bookRepository.findById(id);
    }

    // endpoint para crear el libro
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Book save(@Validated @RequestBody Book book){
        System.out.println("Book received: " + book);
        return bookRepository.save(book);
    }

    @PutMapping("/{id}")
    public Optional<Book> update(@Validated @PathVariable Long id, @RequestBody Book book){
        Optional<Book> book1 = findById(id);
        return Optional.of(bookRepository.save(book));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        Optional<Book> book1 = findById(id);
        bookRepository.deleteById(id);
    }

}
