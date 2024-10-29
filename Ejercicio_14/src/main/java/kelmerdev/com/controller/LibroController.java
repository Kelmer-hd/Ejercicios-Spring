package kelmerdev.com.controller;

import jakarta.validation.Valid;
import kelmerdev.com.dto.LibroRequest;
import kelmerdev.com.dto.LibroResponse;
import kelmerdev.com.service.LibroService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
@AllArgsConstructor
public class LibroController {

    private LibroService libroService;

    @PostMapping
    public ResponseEntity<LibroResponse> createLibro(@RequestBody @Valid LibroRequest request) {
        LibroResponse response = libroService.createLibro(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibroResponse> updateLibro(@PathVariable Long id, @RequestBody @Valid LibroRequest request) {
       LibroResponse response = libroService.updateLibro(id, request);
       return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable Long id) {
        libroService.deleteLibro(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroResponse> getLibroById(@PathVariable Long id) {
        LibroResponse response = libroService.getLibroById(id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<LibroResponse>> getAllLibros() {
        List<LibroResponse> response = libroService.getAllLibros();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
