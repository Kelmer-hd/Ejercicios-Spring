package com.kelmerdev.model.dto;

import com.kelmerdev.model.entity.Consultation;
import lombok.Data;

import java.util.List;

@Data
public class VeterinarianDTO {

    private String firstName;
    private String lastName;
    private String specialty;
    private String licenseNumber;
    private List<Consultation> consultations;
}
