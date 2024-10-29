package kelmerdev.com.repository;

import kelmerdev.com.dto.RestaurantResponse;
import kelmerdev.com.model.RCategory;
import kelmerdev.com.model.RStatus;
import kelmerdev.com.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant>findByCategoryAndStatus(RCategory category, RStatus status);

    // Consulta para actualizar el estado de un restaurante
    @Modifying
    @Transactional
    @Query("UPDATE Restaurant r SET r.status = :status WHERE r.id = :id")
    void updateStatus(Long id, RStatus status);
}
