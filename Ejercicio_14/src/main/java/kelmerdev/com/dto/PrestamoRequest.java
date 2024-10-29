package kelmerdev.com.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PrestamoRequest {
    @NotNull(message = "El ID del libro es obligatorio")
    private Long libroId;

    @NotNull(message = "El ID del usuario es obligatorio")
    private Long usuarioId;
}