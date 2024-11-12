package kelmerdev.com.ejercicio_08;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
    private String nombreCliente;
    private String infoContacto;
    private String direccionCompleta;
}
