package kelmerdev.com.ejercicio_08;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Direccion {
    private String calle;
    private String ciudad;
    private String pais;
}
