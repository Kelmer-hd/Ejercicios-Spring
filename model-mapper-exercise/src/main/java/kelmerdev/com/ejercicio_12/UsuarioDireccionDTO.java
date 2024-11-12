package kelmerdev.com.ejercicio_12;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDireccionDTO {
    private String nombreCompleto;
    private String direccionCompleta;
}
