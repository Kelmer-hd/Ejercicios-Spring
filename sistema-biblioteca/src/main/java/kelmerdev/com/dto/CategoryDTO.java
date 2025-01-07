package kelmerdev.com.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class CategoryDTO {

    @NotBlank(message = "El campo nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El campo descripción es obligatorio")
    private String descripcion;
}
