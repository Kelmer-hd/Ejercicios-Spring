package com.kelmerdev.repository;

import com.kelmerdev.model.Curso;
import com.kelmerdev.model.Nivel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {

   List<Curso> findByNivel(Nivel nivel);

   List<Curso> findByPrecioBetween(Double precioMin, Double precioMax);
}
