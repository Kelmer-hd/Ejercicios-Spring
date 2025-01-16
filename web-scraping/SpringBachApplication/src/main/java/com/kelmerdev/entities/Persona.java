package com.kelmerdev.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "personas")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name = "last_name")
    private String lastName;
    private int age;

    @Column(name = "insertion_date")
    private String insertionDate;
}
