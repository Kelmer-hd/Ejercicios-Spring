package com.kelmerdev.controller;

import com.kelmerdev.entity.Plato;
import com.kelmerdev.services.PlatoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/platos")
@AllArgsConstructor
public class PlatoController {
    private final PlatoService platoService;

    @GetMapping
    public List<Plato> getAll() {
        return platoService.getAll();
    }

    @GetMapping("/{id}")
    public Plato getById(@PathVariable("id") Long id) {
        return platoService.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Plato create(@RequestBody @Validated Plato plato) {
        return platoService.save(plato);
    }

    @PutMapping("/{id}")
    public Plato update(@PathVariable Long id, @Validated  @RequestBody Plato plato) {
        return platoService.update(id, plato);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        platoService.delete(id);
    }
}
