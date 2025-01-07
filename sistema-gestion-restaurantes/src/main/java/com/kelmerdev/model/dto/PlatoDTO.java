package com.kelmerdev.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PlatoDTO {

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotNull(message = "El precio no puede estar vacío")
    private double precio;

    @NotBlank(message = "La categoría no puede estar vacía")
    private String categoria;

    @NotNull(message = "El tiempo de preparación no puede estar vacío")
    private double tiempoPreparacion;

    @NotNull(message = "La disponibilidad no puede estar vacía")
    private boolean disponible;
}
