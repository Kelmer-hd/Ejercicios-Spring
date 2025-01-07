package com.kelmerdev.model.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Veterinarian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String specialty;
    private String licenseNumber;

    @OneToMany(mappedBy = "veterinarian")
    private List<Consultation> consultations;


}
