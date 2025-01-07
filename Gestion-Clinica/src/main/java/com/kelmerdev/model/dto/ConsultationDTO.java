package com.kelmerdev.model.dto;

import com.kelmerdev.model.entity.Pet;
import com.kelmerdev.model.entity.Veterinarian;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ConsultationDTO {

    private LocalDate date;
    private String reason;
    private String diagnosis;
    private String treatment;
    private LocalDate nextVisit;
    private Pet pet;
    private Veterinarian veterinarian;
}
