package com.kelmerdev.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numeroMesa;
    private int capacidad;
    private Estado estado;

    public enum Estado {
        LIBRE, OCUPADA, RESERVADA
    }

}
