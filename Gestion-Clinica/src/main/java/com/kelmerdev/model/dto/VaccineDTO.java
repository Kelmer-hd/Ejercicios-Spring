package com.kelmerdev.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class VaccineDTO {
    private String name;
    private LocalDate applicationDate;
    private LocalDate nextDate;
}
