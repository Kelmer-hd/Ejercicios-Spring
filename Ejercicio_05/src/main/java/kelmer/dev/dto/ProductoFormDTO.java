package kelmer.dev.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductoFormDTO {

    @NotNull
    @Size(min = 3, max = 250)
    private String nombre;

    @NotNull
    @Min(0)
    private double precio;

}
