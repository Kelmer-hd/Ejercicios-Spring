package kelmerdev.com.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fechaPrestamo;
    private LocalDateTime fechaVencimiento;
    private LocalDateTime fechaDevolucion;

    @Enumerated(EnumType.STRING)
    private LoanStatus status;

    // Relación ManyToOne con User
    // Muchos préstamos pueden pertenecer a un usuario
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Book book;

    // Relación ManyToOne con Book
    // Muchos préstamos pueden ser del mismo libro
    @ManyToOne
    @JoinColumn(name = "book_id")
    private User user;
}
