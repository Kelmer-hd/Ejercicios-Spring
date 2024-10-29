package kelmerdev.com.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Entity
@Table(name = "books")
@Data
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "isbn" ,nullable = false, unique = true)
    private String isbn;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private Integer yearPublished;

    @Column(nullable = false)
    private Integer copiesAvailable;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusLibro status;
}
