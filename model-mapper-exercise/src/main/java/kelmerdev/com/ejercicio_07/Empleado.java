package kelmerdev.com.ejercicio_07;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {
    private String nombre;
    private Departamento departamento;
}


