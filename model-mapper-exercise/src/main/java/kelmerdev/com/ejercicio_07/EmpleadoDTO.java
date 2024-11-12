package kelmerdev.com.ejercicio_07;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoDTO {
    private String nombreCompleto;
    private String departamentoNombre;
    private String departamentoUbicacion;
}
