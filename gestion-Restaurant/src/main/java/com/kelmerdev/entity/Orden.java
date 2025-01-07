package com.kelmerdev.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Estado estado;
    private LocalDateTime fecha;
    private double total;
    private String metodoPago;
    private String notasEspeciales;

    public enum Estado {
        PENDIENTE, EN_PREPARACION, LISTA, ENTREGADA, PAGADA
    }

    @OneToOne
    public Mesa mesa;

    @OneToMany(targetEntity = Plato.class)
    private List<Plato> platos = new ArrayList<>();
}
