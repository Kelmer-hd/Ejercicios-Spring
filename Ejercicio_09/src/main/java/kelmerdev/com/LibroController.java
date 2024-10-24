package kelmerdev.com;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/libros")
@AllArgsConstructor
public class LibroController {

    private LibroService libroService;

    @GetMapping
    public List<Libro> listar() {
        return  libroService.getLibros();
    }

    @PostMapping
    public Libro agregar(@RequestBody Libro libro){
        return libroService.create(libro);
    }
}
