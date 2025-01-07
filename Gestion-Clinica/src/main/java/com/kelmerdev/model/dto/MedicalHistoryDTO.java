package com.kelmerdev.model.dto;

import com.kelmerdev.model.entity.Pet;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MedicalHistoryDTO {

    private LocalDate date;
    private String type_record;
    private String description;
    private String medications;
    private Pet pet;
}
