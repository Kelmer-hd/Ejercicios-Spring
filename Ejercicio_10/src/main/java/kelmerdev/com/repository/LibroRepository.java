package kelmerdev.com.repository;

import kelmerdev.com.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

    Libro findByAutor(String autor);
    Libro findByTitulo(String titulo);
}
