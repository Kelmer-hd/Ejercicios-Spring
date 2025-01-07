package com.kelmerdev.controller;

import com.kelmerdev.model.dto.PlatoDTO;
import com.kelmerdev.model.entity.Plato;
import com.kelmerdev.service.PlatoService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/platos")
public class PlatoController {

    public final PlatoService platoService;

    @GetMapping
    public List<Plato> findAll() {
        return platoService.findAll();
    }

    @GetMapping("/{id}")
    public Plato findById(@PathVariable Long id) {
        return platoService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Plato save(@RequestBody @Validated PlatoDTO platoDTO) {
        return platoService.save(platoDTO);
    }

    @PutMapping("/{id}")
    public Plato update(@PathVariable Long id, @RequestBody @Validated PlatoDTO platoDTO) {
        return platoService.update(id, platoDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        platoService.delete(id);
    }
}
