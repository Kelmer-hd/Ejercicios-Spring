package kelmerdev.com.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Biblioteca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;


}
