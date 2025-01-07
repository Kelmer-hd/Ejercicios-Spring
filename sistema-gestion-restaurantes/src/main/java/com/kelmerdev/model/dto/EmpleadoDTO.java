package com.kelmerdev.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmpleadoDTO {

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "El rol no puede estar vacío")
    private String rol;

    @NotBlank(message = "El turno no puede estar vacío")
    private String turno;
}
