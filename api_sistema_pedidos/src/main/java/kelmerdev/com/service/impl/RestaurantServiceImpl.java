package kelmerdev.com.service.impl;

import kelmerdev.com.dto.RestaurantRequest;
import kelmerdev.com.dto.RestaurantResponse;
import kelmerdev.com.exception.ResourceNotFoundException;
import kelmerdev.com.mapper.RestaurantMapper;
import kelmerdev.com.model.RCategory;
import kelmerdev.com.model.RStatus;
import kelmerdev.com.model.Restaurant;
import kelmerdev.com.repository.RestaurantRepository;
import kelmerdev.com.service.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantMapper restaurantMapper;
    private final RestaurantRepository restaurantRepository;

    @Override
    public RestaurantResponse create(RestaurantRequest request) {
        Restaurant restaurant = restaurantMapper.restaurantRequestToRestaurant(request);
        restaurant = restaurantRepository.save(restaurant);
        return restaurantMapper.restaurantToRestaurantResponse(restaurant);

    }

    @Override
    public RestaurantResponse update(Long id, RestaurantRequest request) {
        RestaurantResponse restaurant = findById(id);
        restaurant.setName(request.getName());
        restaurant.setAddress(request.getAddress());
        restaurant.setPhone(request.getPhone());
        restaurant.setCategory(request.getCategory());
        restaurant.setOpenTime(request.getOpenTime());
        restaurant.setCloseTime(request.getCloseTime());
        restaurant.setStatus(request.getStatus());
        restaurant.setQualification(request.getQualification());

        return restaurant;
    }

    @Override
    public RestaurantResponse findById(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id: " + id));

        return restaurantMapper.restaurantToRestaurantResponse(restaurant);
    }

    @Override
    public RestaurantResponse findAll() {
        return null;
    }

    @Override
    public RestaurantResponse updateStatus(Long id, String status) {
        return null;
    }

    @Override
    public List<RestaurantResponse> findByCategoryAndStatus(RCategory category, RStatus status) {
        List<Restaurant> restaurants = restaurantRepository.findByCategoryAndStatus(category, status);
        return restaurants.stream()
                .map(restaurantMapper::restaurantToRestaurantResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void updateStatus(Long id, RStatus status) {
        if (!restaurantRepository.existsById(id)){
            throw new ResourceNotFoundException("Restaurant not found with id: " + id);
        }
        restaurantRepository.updateStatus(id, status);
    }


}
