package kelmerdev.com.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String isbn;
    private String title;
    private String autor;
    private String descripcion;
    private Integer copiesAvailable;

    @ManyToMany
    @JoinTable(
            name = "book_categories",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "categoy_id")
    )
    private List<Category> categories;

    // Relación OneToMany con Loan
    // Un libro puede tener muchos préstamos
    /*
    @OneToMany(mappedBy = "book")
    private List<Loan> loans;

    */

}
