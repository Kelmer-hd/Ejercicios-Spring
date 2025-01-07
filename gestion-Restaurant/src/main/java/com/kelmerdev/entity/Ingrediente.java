package com.kelmerdev.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Ingrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int stock;
    private UnidadMedida unidadMedida;
    private int stockMinimo;
    private int stockMaximo;

    public enum UnidadMedida {
        KG, UNIDAD, LITRO
    }

}
