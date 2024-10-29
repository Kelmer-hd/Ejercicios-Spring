package kelmerdev.com.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "loans")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "libro_id", nullable = false)
    private Libro libro;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private User usuario;

    @Column(nullable = false)
    private LocalDateTime fechaPrestamo;

    @Column(nullable = false)
    private LocalDateTime fechaDevolucionEsperada;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusPrestamo status;
}