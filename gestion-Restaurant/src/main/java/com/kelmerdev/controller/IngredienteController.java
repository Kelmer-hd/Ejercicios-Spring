package com.kelmerdev.controller;

import com.kelmerdev.entity.Ingrediente;
import com.kelmerdev.services.IngredientesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/ingredientes")
public class IngredienteController {

    public IngredientesService ingredientesService;

    @GetMapping
    public List<Ingrediente> findAll() {
        return ingredientesService.findAll();
    }

    @GetMapping("/{id}")
    public Ingrediente findById(@PathVariable Long id) {
        return ingredientesService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Ingrediente create(@RequestBody @Validated Ingrediente ingrediente) {
        return ingredientesService.save(ingrediente);
    }

    @PutMapping("/{id}")
    public Ingrediente update(@PathVariable Long id, @RequestBody @Validated Ingrediente ingrediente) {
        return ingredientesService.update(id, ingrediente);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ingredientesService.delete(id);
    }
}

