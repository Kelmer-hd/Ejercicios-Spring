package kelmerdev.com.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import kelmerdev.com.entity.Category;
import lombok.Data;

import java.util.List;

@Data
public class BookDTO {

    @NotBlank(message = "el isbn es obligatorio")
    private String isbn;

    @NotBlank(message = "El titulo es obligatorio")
    private String title;

    @NotBlank(message = "El autor es obligatorio")
    private String autor;

    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;

    @NotNull(message = "El numero de copias son obligatorias")
    @Min(value = 0, message = "El numero de copias debe ser mayor a 0")
    private Integer copiesAvailable;

    private List<Long> categoryIds;

}
