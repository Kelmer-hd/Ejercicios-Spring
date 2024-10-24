package kelmerdev.com.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import kelmerdev.com.model.Biblioteca;
import kelmerdev.com.service.BibliotecaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/bibliotecas")
@Tag(name = "Biblioteca", description = "Biblioteca Management API")
public class BibliotecaController {
    private BibliotecaService bibliotecaService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Biblioteca create(@RequestBody Biblioteca biblioteca) {
        return bibliotecaService.create(biblioteca);
    }

    @Operation(summary = "Ver lista de bibliotecas disponibles")
    @GetMapping
    public List<Biblioteca> getAll() {
        return bibliotecaService.getAll();
    }

    @Operation(summary = "Obtener una biblioteca por ID")
    @ApiResponse(responseCode = "200", description = "Biblioteca encontrada")
    @ApiResponse(responseCode = "404", description = "Biblioteca no encontrada")
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
