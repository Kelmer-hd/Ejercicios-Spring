package kelmerdev.com.ejercicio_06;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibroDTO {
    private String tituloLibro;
    private String nombreAutor;
    private int anioEdicion;

}
