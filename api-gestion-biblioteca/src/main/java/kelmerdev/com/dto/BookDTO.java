package kelmerdev.com.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BookDTO {

    @NotBlank(message = "El título no puede estar vacío")
    private String title;

    @NotBlank(message = "El autor no puede estar vacío")
    private String author;

    @NotBlank(message = "El ISBN no puede estar vacío")
    private String isbn;

    @NotBlank(message = "El año de publicación no puede estar vacío")
    private Integer publisedYear;
}
