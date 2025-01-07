package com.kelmerdev.dto;

import com.kelmerdev.model.CEstado;
import com.kelmerdev.model.Nivel;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class CursoDTO {

    @NotBlank(message = "El campo nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El campo descripción en obligatorio")
    private String descripcion;

    @Min(value = 0, message = "La duración del curso debe ser mayor que cero")
    private double duracion;

    @Min(value = 0, message = "El precio debe ser mayor que cero")
    private Double precio;
    private Nivel nivel;
    private CEstado estado;

}
