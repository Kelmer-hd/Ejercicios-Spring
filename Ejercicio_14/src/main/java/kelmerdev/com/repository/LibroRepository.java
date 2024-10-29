package kelmerdev.com.repository;

import kelmerdev.com.dto.LibroResponse;
import kelmerdev.com.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    // Resporna true / false
    boolean existsByIsbn(String isbn);
}
