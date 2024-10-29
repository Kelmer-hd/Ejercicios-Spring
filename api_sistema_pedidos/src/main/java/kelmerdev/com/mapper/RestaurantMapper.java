package kelmerdev.com.mapper;

import kelmerdev.com.dto.RestaurantRequest;
import kelmerdev.com.dto.RestaurantResponse;
import kelmerdev.com.model.Restaurant;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RestaurantMapper {

    private final ModelMapper modelMapper;

    public RestaurantMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
        configureModelMapper();
    }

    private void configureModelMapper() {
        modelMapper.typeMap(RestaurantRequest.class, Restaurant.class).addMappings(mapping ->{
            mapping.map(RestaurantRequest::getName, Restaurant::setName);
            mapping.map(RestaurantRequest::getAddress, Restaurant::setAddress);
            mapping.map(RestaurantRequest::getPhone, Restaurant::setPhone);
            mapping.map(RestaurantRequest::getCategory, Restaurant::setCategory);
            mapping.map(RestaurantRequest::getOpenTime, Restaurant::setOpenTime);
            mapping.map(RestaurantRequest::getCloseTime, Restaurant::setCloseTime);
            mapping.map(RestaurantRequest::getStatus, Restaurant::setStatus);
            mapping.map(RestaurantRequest::getQualification, Restaurant::setQualification);
        });

        modelMapper.typeMap(Restaurant.class, RestaurantResponse.class).addMappings(mapping ->{
            mapping.map(Restaurant::getId, RestaurantResponse::setId);
            mapping.map(Restaurant::getName, RestaurantResponse::setName);
            mapping.map(Restaurant::getAddress, RestaurantResponse::setAddress);
            mapping.map(Restaurant::getPhone, RestaurantResponse::setPhone);
            mapping.map(Restaurant::getCategory, RestaurantResponse::setCategory);
            mapping.map(Restaurant::getOpenTime, RestaurantResponse::setOpenTime);
            mapping.map(Restaurant::getCloseTime, RestaurantResponse::setCloseTime);
            mapping.map(Restaurant::getStatus, RestaurantResponse::setStatus);
            mapping.map(Restaurant::getQualification, RestaurantResponse::setQualification);
        });

    }

    public Restaurant restaurantRequestToRestaurant(RestaurantRequest request){
        return modelMapper.map(request, Restaurant.class);
    }

    public RestaurantResponse restaurantToRestaurantResponse(Restaurant restaurant){
        return modelMapper.map(restaurant, RestaurantResponse.class);
    }

    public List<Restaurant> restaurantRequestListToRestaurantList(List<RestaurantRequest> requests){
        return requests.stream()
                .map(this::restaurantRequestToRestaurant)
                .collect(Collectors.toList());
    }

    public List<RestaurantResponse> restaurantListToRestaurantResponseList(List<Restaurant> restaurants){
        return restaurants.stream()
                .map(this::restaurantToRestaurantResponse)
                .collect(Collectors.toList());
    }

}
