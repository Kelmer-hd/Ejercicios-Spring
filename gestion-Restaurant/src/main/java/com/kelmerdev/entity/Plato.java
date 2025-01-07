package com.kelmerdev.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Plato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private double precio;
    private Categoria categoria;
    private double tiempo;
    private Estado estado;

    public enum Categoria {
        ENTRADA, PRINCIPAL, POSTRE, BEBIDA
    }

    public enum Estado {
        DISPONIBLE, NO_DISPONIBLE
    }

    @ManyToMany(targetEntity = Ingrediente.class)
    List<Ingrediente> ingredientes = new ArrayList<>();
}
