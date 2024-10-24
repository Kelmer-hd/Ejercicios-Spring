package kelmerdev.com;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LIbroRepository extends JpaRepository<Libro, Long> {
}
