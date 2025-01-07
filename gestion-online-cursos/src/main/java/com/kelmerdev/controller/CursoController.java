package com.kelmerdev.controller;

import com.kelmerdev.dto.CursoDTO;
import com.kelmerdev.model.Curso;
import com.kelmerdev.model.Estudiante;
import com.kelmerdev.model.Nivel;
import com.kelmerdev.service.CursoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoService cursoService;

    @GetMapping
    public List<Curso> list() {
        return cursoService.getAll();
    }

    @GetMapping("/{id}")
    public Curso get(@PathVariable Long id) {
        return cursoService.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Curso create(@RequestBody @Validated CursoDTO cursoDTO) {
        return cursoService.save(cursoDTO);
    }

    @PutMapping("/{id}")
    public Curso update(@PathVariable Long id, @Validated @RequestBody CursoDTO cursoDTO) {
        return cursoService.update(id, cursoDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        cursoService.delete(id);
    }

    // Enpoint para poder inscribir un estuduante a un curso
    @PostMapping("/{cursoId}/inscribir/{estudianteId}")
    public void inscribirEstudiante(@PathVariable Long cursoId, @PathVariable Long estudianteId) {
        cursoService.inscribirse(cursoId, estudianteId);
    }

    // Endpoint para dar de baja a un estudiante de un curso
    @DeleteMapping("/{cursoId}/dar-baja/{estudianteId}")
    public void darBajaEstudiante(@PathVariable Long cursoId, @PathVariable Long estudianteId) {
        cursoService.darBajaEstudiante(estudianteId, cursoId);
    }

    // Obtener los cursos de un estudiante
    @GetMapping("/estudiante/{estudianteId}")
    public List<Curso> obtenerCursosDeEstudiante(@PathVariable Long estudianteId) {
        return cursoService.obtenerCursosDeEstudiante(estudianteId);
    }

    // Obtener los estudiantes de un curso
    @GetMapping("/{cursoId}/estudiantes")
    public List<Estudiante> obtenerEstudiantesDeCurso(@PathVariable Long cursoId) {
        return cursoService.obtenerEstudiantesDeCurso(cursoId);
    }

    // Buscar cursos por nivel
    @GetMapping("/nivel/{nivel}")
    public List<Curso> buscarCursosPorNivel(@PathVariable Nivel nivel) {
        return cursoService.buscarCursosPorNivel(nivel);
    }

    // Buscar cursos por rango de precio
    @GetMapping("/precio")
    public List<Curso> buscarCursosPorPrecio(@RequestParam Double precioMin, @RequestParam Double precioMax) {
        return cursoService.buscarCursosPorPrecio(precioMin, precioMax);
    }
}
