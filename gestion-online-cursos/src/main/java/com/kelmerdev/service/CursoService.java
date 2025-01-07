package com.kelmerdev.service;

import com.kelmerdev.dto.CursoDTO;
import com.kelmerdev.exeception.ResourceNotFoundException;
import com.kelmerdev.model.Curso;
import com.kelmerdev.model.Estudiante;
import com.kelmerdev.model.Nivel;
import com.kelmerdev.repository.CursoRepository;
import com.kelmerdev.repository.EstudianteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class CursoService {

    private CursoRepository cursoRepository;
    private EstudianteRepository estudianteRepository;

    public List<Curso> getAll() {
        return cursoRepository.findAll();
    }

    public Curso getById(Long id) {
        return cursoRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Curso save(CursoDTO cursoDTO) {
        Curso curso = new Curso();
        curso.setNombre(cursoDTO.getNombre());
        curso.setDescripcion(cursoDTO.getDescripcion());
        curso.setPrecio(cursoDTO.getPrecio());
        curso.setDuracion(cursoDTO.getDuracion());
        curso.setNivel(cursoDTO.getNivel());
        curso.setEstado(cursoDTO.getEstado());
        return cursoRepository.save(curso);
    }

    public Curso update(Long id, CursoDTO cursoDTO) {
        Curso curso = getById(id);
        curso.setNombre(cursoDTO.getNombre());
        curso.setDescripcion(cursoDTO.getDescripcion());
        curso.setPrecio(cursoDTO.getPrecio());
        curso.setNivel(cursoDTO.getNivel());
        curso.setDuracion(cursoDTO.getDuracion());
        curso.setEstado(cursoDTO.getEstado());
        return cursoRepository.save(curso);
    }

    public void delete(Long id) {
        Curso curso = getById(id);
        cursoRepository.deleteById(curso.getId());
    }

    // Método para inscribir un estudiante a un curso
    public void inscribirse(Long estudianteId, Long cursoId) {
        Estudiante estudiante = estudianteRepository.findById(estudianteId).orElseThrow(ResourceNotFoundException::new);

        Curso curso = cursoRepository.findById(cursoId).orElseThrow(ResourceNotFoundException::new);

        if (!estudiante.getCursos().contains(curso)) {
            estudiante.getCursos().add(curso);
            curso.getEstudiantes().add(estudiante); // Si tu `Curso` tiene la lista de estudiantes también, actualiza ambos lados
            estudianteRepository.save(estudiante);
            cursoRepository.save(curso);
        }
    }

    public void darBajaEstudiante(Long estudianteId, Long cursoId) {
        Estudiante estudiante = estudianteRepository.findById(estudianteId).orElseThrow(ResourceNotFoundException::new);

        Curso curso = cursoRepository.findById(cursoId).orElseThrow(ResourceNotFoundException::new);

        if (!estudiante.getCursos().contains(curso)) {
            estudiante.getCursos().remove(curso);
            curso.getEstudiantes().remove(estudiante);
            estudianteRepository.save(estudiante);
            cursoRepository.save(curso);
        }
    }

    public List<Curso> obtenerCursosDeEstudiante(Long estudianteId) {
        Estudiante estudiante = estudianteRepository.findById(estudianteId).orElseThrow(ResourceNotFoundException::new);

        return estudiante.getCursos();
    }

    public List<Estudiante> obtenerEstudiantesDeCurso(Long CursoId) {
        Curso curso = cursoRepository.findById(CursoId).orElseThrow(ResourceNotFoundException::new);

        return curso.getEstudiantes();
    }

    public List<Curso> buscarCursosPorNivel(Nivel nivel){
        return cursoRepository.findByNivel(nivel);
    }

    public List<Curso> buscarCursosPorPrecio(Double precioMin, Double precioMax){
        return cursoRepository.findByPrecioBetween(precioMin, precioMax);
    }

}
