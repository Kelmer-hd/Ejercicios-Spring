package kelmerdev.com.controller;

import kelmerdev.com.dto.LibroDTO;
import kelmerdev.com.model.Libro;
import kelmerdev.com.service.LibroService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class LibroController {
    private LibroService libroService;

    // Crear un libro en una biblioteca especifica
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/bibliotecas/{bibliotecaId}/libros")
    public Libro create(@Validated @PathVariable Long bibliotecaId, @Validated @RequestBody LibroDTO libroDTO) {
        return libroService.create(bibliotecaId, libroDTO);
    }


    @GetMapping("/libros")
    public List<Libro> findAll() {
        return libroService.findAll();
    }

    @GetMapping("/libros/{id}")
    public Libro findById(@PathVariable Long id) {
        return libroService.findById(id);
    }

    @PutMapping("/libros/{id}")
    public Libro update(@PathVariable Long id, @Validated LibroDTO libroDTO) {
        return libroService.update(id, libroDTO);
    }

    @DeleteMapping("/libros/{id}")
    public void delete(@PathVariable Long id) {
        libroService.delete(id);
    }

    @GetMapping("/libros/autor/{autor}")
    public Libro getLibroByAutor(@PathVariable String autor){
        return libroService.getLibroByAutor(autor);
    }

    @GetMapping("/libros/titulo/{titulo}")
    public Libro getLibroByTitulo(@PathVariable String titulo){
        return libroService.getLibroByTitulo(titulo);
    }
}
