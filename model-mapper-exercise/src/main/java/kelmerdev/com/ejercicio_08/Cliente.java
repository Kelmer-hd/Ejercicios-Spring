package kelmerdev.com.ejercicio_08;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    private String nombre;
    private String telefono;
    private Direccion direccion;
}
