package kelmerdev.com.dto;

import jakarta.validation.constraints.NotNull;
import kelmerdev.com.model.PCategoria;
import lombok.Data;

@Data
public class ProductRequest {

    @NotNull(message = "El nombre del producto es obligatorio")
    private String name;

    @NotNull(message = "La descripción del producto es obligatoria")
    private String description;

    @NotNull(message = "El precio del producto es obligatorio")
    private double price;

    @NotNull(message = "La categoria del producto es obligatoria")
    private PCategoria category;

    @NotNull(message = "La disponibilidad del producto es obligatoria")
    private boolean isAvailable;

    @NotNull(message = "El tiempo de preparación del producto es obligatorio")
    private Integer preparationTime;

}
