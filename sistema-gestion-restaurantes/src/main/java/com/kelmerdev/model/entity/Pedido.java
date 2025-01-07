package com.kelmerdev.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String estado;
    private LocalDate fecha;
    private double total;

    @OneToOne
    private Mesa mesa;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "pedido_plato",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "plato_id")
    )
    private List<Plato> platos;

}
