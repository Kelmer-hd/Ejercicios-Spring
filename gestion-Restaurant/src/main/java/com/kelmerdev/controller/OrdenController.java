package com.kelmerdev.controller;

import com.kelmerdev.entity.Orden;
import com.kelmerdev.services.OrdenService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orden")
@AllArgsConstructor
public class OrdenController {
    private final OrdenService ordenService;

    @GetMapping
    public List<Orden> list() {
        return ordenService.getAll();
    }

    @GetMapping("/{id}")
    public Orden get(@PathVariable long id) {
        return ordenService.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Orden create(@RequestBody @Validated Orden orden) {
        return ordenService.save(orden);
    }

    @PutMapping("/{id}")
    public Orden update(@PathVariable long id, @Validated @RequestBody Orden orden) {
        return ordenService.update(id, orden);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        ordenService.delete(id);
    }
}
