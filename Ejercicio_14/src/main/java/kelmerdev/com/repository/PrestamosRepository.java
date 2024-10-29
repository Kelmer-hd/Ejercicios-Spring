package kelmerdev.com.repository;

import kelmerdev.com.model.Prestamo;
import kelmerdev.com.model.StatusPrestamo;
import kelmerdev.com.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrestamosRepository extends JpaRepository<Prestamo, Long> {
    long countByUsuarioAndStatus(User usuario, StatusPrestamo status);
    List<Prestamo> findByUsuarioId(Long usuarioId);
}
