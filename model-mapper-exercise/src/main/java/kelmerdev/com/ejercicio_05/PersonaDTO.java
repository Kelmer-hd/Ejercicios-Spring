package kelmerdev.com.ejercicio_05;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO {
    private String nombreCompleto;
    private int aniosVividos;

}
