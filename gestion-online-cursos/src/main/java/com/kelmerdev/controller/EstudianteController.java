package com.kelmerdev.controller;

import com.kelmerdev.dto.EstudianteDTO;
import com.kelmerdev.model.Estudiante;
import com.kelmerdev.service.EstudianteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private final EstudianteService estudianteService;

    @GetMapping
    public List<Estudiante> index() {
        return estudianteService.getEstudiantes();
    }

    @GetMapping("/{id}")
    public Estudiante show(@PathVariable Long id) {
        return estudianteService.getEstudiante(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Estudiante create(@RequestBody @Validated EstudianteDTO estudianteDTO) {
        return estudianteService.save(estudianteDTO);
    }

    @PutMapping("/{id}")
    public Estudiante update(@PathVariable Long id, @Validated @RequestBody EstudianteDTO estudianteDTO) {
        return estudianteService.update(id, estudianteDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        estudianteService.delete(id);
    }
}
