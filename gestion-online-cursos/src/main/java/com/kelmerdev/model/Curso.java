package com.kelmerdev.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private double duracion;
    private Double precio;

    @Enumerated(EnumType.STRING)
    private Nivel nivel;

    @Enumerated(EnumType.STRING)
    private CEstado estado;

    @ManyToMany(mappedBy = "cursos")
    private List<Estudiante> estudiantes;

}


