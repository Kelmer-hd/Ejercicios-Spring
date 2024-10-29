package kelmerdev.com.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import kelmerdev.com.model.StatusLibro;
import lombok.Data;

@Data
public class LibroRequest {

    @NotBlank(message = "El campo es obligatorio")
    private String isbn;

    @NotBlank(message = "El campo es obligatorio")
    private String title;

    @NotBlank(message = "El campo es obligatorio")
    private String author;

    @NotNull(message = "El campo es obligatorio")
    @Min(value = 1900, message = "El año de publicación debe ser mayor a 1900")
    private Integer yearPublished;

    @NotNull(message = "El campo es obligatorio")
    @Min(value = 1, message = "El campo no puede ser menor a 1")
    private Integer copiesAvailable;

    @NotNull(message = "El estado del libro es obligatorio")
    private StatusLibro status = StatusLibro.DISPONIBLE;

}
