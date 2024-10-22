package kelmer.dev.controller;

import kelmer.dev.model.Libro;
import kelmer.dev.repository.LibroRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/api/libros")
public class LibroController {

    private LibroRepository libroRepository;

    @GetMapping
    public ResponseEntity<List<Libro>> todosLosLibros(){
        return ResponseEntity.ok().body(libroRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> libroPorId(@PathVariable Long id){
        return libroRepository.findById(id)
                .map(libro -> ResponseEntity.ok().body(libro))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Libro> crearLibro(@RequestBody Libro libro){
        return ResponseEntity.ok().body(libroRepository.save(libro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizarLibro(@PathVariable Long id, @RequestBody Libro libro){
        return libroRepository.findById(id)
                .map(libroData -> {
                    libroData.setTitulo(libro.getTitulo());
                    libroData.setAutor(libro.getAutor());
                    libroData.setAnioPublicacion(libro.getAnioPublicacion());
                    libroData.setIsbn(libro.getIsbn());
                    return ResponseEntity.ok().body(libroRepository.save(libroData));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarLibro(@PathVariable Long id){
        return libroRepository.findById(id)
                .map(libro -> {
                    libroRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
