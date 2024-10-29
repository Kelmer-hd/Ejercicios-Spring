package kelmerdev.com.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import kelmerdev.com.model.RCategory;
import kelmerdev.com.model.RStatus;
import lombok.Data;

import java.time.LocalTime;


@Data
public class RestaurantRequest {

    @NotBlank(message = "El nombre del restaurante no puede estar vacío")
    private String name;

    @NotNull(message = "La dirección del restaurante no puede estar vacía")
    private String address;

    @NotBlank(message = "El teléfono del restaurante no puede estar vacío")
    private String phone;

    @NotNull(message = "La categoria del restaurante no puede estar vacía")
    private RCategory category;

    @JsonFormat(pattern = "HH:mm:ss")
    @NotNull(message = "El horario de apertura del restaurante no puede estar vacío")
    private LocalTime openTime;

    @JsonFormat(pattern = "HH:mm:ss")
    @NotNull(message = "El horario de cierre del restaurante no puede estar vacío")
    private LocalTime closeTime;

    @NotNull(message = "El estado del restaurante no puede estar vacío")
    private RStatus status;

    private double qualification;
}
