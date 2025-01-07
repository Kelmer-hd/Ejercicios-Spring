package kelmerdev.com.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nombre;
    private String apellido;

    @Column(unique = true)
    private String email;
    private String password;
    private String direccion;

    @Enumerated(EnumType.STRING)
    private Roles roles;
}
