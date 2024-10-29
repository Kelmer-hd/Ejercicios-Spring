package kelmerdev.com.service;

import kelmerdev.com.dto.RestaurantRequest;
import kelmerdev.com.dto.RestaurantResponse;
import kelmerdev.com.model.RCategory;
import kelmerdev.com.model.RStatus;
import kelmerdev.com.model.Restaurant;

import java.util.List;

public interface RestaurantService {

    RestaurantResponse create(RestaurantRequest request);
    RestaurantResponse update(Long id, RestaurantRequest request);
    RestaurantResponse findById(Long id);
    RestaurantResponse findAll();RestaurantResponse updateStatus(Long id, String status);

    List<RestaurantResponse> findByCategoryAndStatus(RCategory category, RStatus status);

    void updateStatus(Long id, RStatus status);
}
