package com.kelmerdev.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private String reason;
    private String diagnosis;
    private String treatment;
    private LocalDate nextVisit;

    @ManyToOne
    private Pet pet;

    @ManyToOne
    private Veterinarian veterinarian;

}
