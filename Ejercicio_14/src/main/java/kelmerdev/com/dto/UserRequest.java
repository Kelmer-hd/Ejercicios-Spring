package kelmerdev.com.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequest {

    @NotBlank(message = "El campo es obligatorio")
    private String name;

    @NotBlank(message = "El campo es obligatorio")
    @Email(message = "El campo debe ser un correo electrónico válido")
    private String email;

    @NotBlank(message = "El campo es obligatorio")
    private String membershipNumber;
}
