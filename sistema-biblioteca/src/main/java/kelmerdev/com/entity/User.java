package kelmerdev.com.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Rol roles;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    // Relación OneToMany con Loan
    // Un usuario puede tener muchos préstamos
    @OneToMany(mappedBy = "user")
    private List<Loan> loans;


}
