package com.kelmerdev.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String species;
    private String race;
    private LocalDate birthdate;
    private Double weight;

    @OneToMany(mappedBy = "pet")
    private List<MedicalHistory> medicalHistories;

    @OneToMany(mappedBy = "pet")
    private List<Consultation> consultations;

    @ManyToMany
    @JoinTable(
            name = "pet_vaccine",
            joinColumns = @JoinColumn(name = "pet_id"),
            inverseJoinColumns = @JoinColumn(name = "vaccine_id")
    )
    private List<Vaccine> vaccines;

    @ManyToOne
    private Owner owner;


}
