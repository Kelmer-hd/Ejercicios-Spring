package com.kelmerdev.model.dto;

import com.kelmerdev.model.entity.Consultation;
import com.kelmerdev.model.entity.MedicalHistory;
import com.kelmerdev.model.entity.Owner;
import com.kelmerdev.model.entity.Vaccine;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PetDTO {

    private String name;
    private String species;
    private String race;
    private LocalDate birthdate;
    private Double weight;
    private List<MedicalHistory> medicalHistories;
    private List<Consultation> consultations;
    private List<Vaccine> vaccines;
    private Owner owner;
}
