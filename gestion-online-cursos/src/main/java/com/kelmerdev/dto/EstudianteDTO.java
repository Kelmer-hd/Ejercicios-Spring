package com.kelmerdev.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;



@Data
public class EstudianteDTO {

    @NotBlank(message = "El campo nombre es obligatorio")
    private String nombre;

    @Email
    @NotBlank(message = "El campo email es obligatorio")
    private String email;

    @NotBlank(message = "El campo teléfono es obligatorio")
    private String telefono;



}
