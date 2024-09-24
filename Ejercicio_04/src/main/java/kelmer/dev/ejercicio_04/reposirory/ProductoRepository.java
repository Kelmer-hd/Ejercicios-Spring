package kelmer.dev.ejercicio_04.reposirory;

import kelmer.dev.ejercicio_04.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
