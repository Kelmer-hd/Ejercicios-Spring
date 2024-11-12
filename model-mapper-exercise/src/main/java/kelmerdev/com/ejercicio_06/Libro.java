package kelmerdev.com.ejercicio_06;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Libro {
    private String titulo;
    private String autor;
    private int anioPublicacion;

}
