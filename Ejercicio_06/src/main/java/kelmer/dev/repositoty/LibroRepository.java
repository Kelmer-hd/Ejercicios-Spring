package kelmer.dev.repositoty;

import kelmer.dev.entiti.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
