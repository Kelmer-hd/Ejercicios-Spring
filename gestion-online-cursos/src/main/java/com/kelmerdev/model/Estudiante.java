package com.kelmerdev.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @Column(unique = true, nullable = false)
    private String email;
    private String telefono;
    private LocalDateTime createAt;

    @ManyToMany
    @JoinTable(
            name = "inscripcion", // NOmbre de la tabla intermdia
            joinColumns = @JoinColumn(name = "estudiante_id"), // Columna de la clave foranea en inscripcion
            inverseJoinColumns = @JoinColumn(name = "curso_id") // Columna de la clave foranea en inscripcion

    )
    List<Curso> cursos;
}
