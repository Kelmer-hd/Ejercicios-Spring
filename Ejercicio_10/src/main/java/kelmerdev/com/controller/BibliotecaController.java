package kelmerdev.com.controller;

import kelmerdev.com.model.Biblioteca;
import kelmerdev.com.service.BibliotecaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/bibliotecas")
public class BibliotecaController {
    private BibliotecaService bibliotecaService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Biblioteca create(@RequestBody Biblioteca biblioteca) {
        return bibliotecaService.create(biblioteca);
    }

    @GetMapping
    public List<Biblioteca> getAll() {
        return bibliotecaService.getAll();
    }

    @GetMapping("/{id}")
    public Biblioteca getById(@PathVariable Long id) {
        return bibliotecaService.getById(id);
    }

    @PutMapping("/{id}")
    public Biblioteca update(@PathVariable Long id, @RequestBody Biblioteca biblioteca) {
        return bibliotecaService.update(id, biblioteca);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bibliotecaService.delete(id);
    }

}
