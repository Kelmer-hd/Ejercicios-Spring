package kelmer.dev.controller;

import kelmer.dev.entiti.Libro;
import kelmer.dev.services.LibroService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/libros")
@AllArgsConstructor
public class LibroController {
    private final LibroService libroService;

    // OBTENER TODOS LOS LIBROS
    @GetMapping
    public List<Libro> getAllLibros(){
        return libroService.getAllLibros();
    }

    @PostMapping
    // AÑADIR UN NUEVO LIBRO
    public Libro create(@RequestBody Libro libro){
        return libroService.create(libro);
    }

}
