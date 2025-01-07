package kelmerdev.com.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    // Campos adicionales para cuando el usuario es un cliente
    private String direccion;
    private String telefono;

    // Solo se usará si el usuario es un cliente
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<OrdenCompra> ordenes;
}
