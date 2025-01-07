package com.kelmerdev.repository;

import com.kelmerdev.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    boolean existsByEmail(String email);
}
