package kelmerdev.com.dto;

import lombok.Data;

@Data
public class UserDto {
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String direccion;

}
