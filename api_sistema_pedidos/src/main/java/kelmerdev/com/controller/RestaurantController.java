package kelmerdev.com.controller;

import jakarta.validation.Valid;
import kelmerdev.com.dto.RestaurantRequest;
import kelmerdev.com.dto.RestaurantResponse;
import kelmerdev.com.model.RCategory;
import kelmerdev.com.model.RStatus;
import kelmerdev.com.service.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
@AllArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<RestaurantResponse> createRestaurant(@Valid @RequestBody RestaurantRequest request){
        RestaurantResponse response = restaurantService.create(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantResponse> updateRestaurant(@PathVariable Long id, @Valid @RequestBody RestaurantRequest request){
        RestaurantResponse response = restaurantService.update(id, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantResponse> getRestaurant(@PathVariable Long id){
        RestaurantResponse response = restaurantService.findById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RestaurantResponse>> findByCategoryAndStatus(@RequestParam("category") RCategory category, @RequestParam("status") RStatus status){
        List<RestaurantResponse> response = restaurantService.findByCategoryAndStatus(category, status);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Void> updateStatus(@PathVariable Long id, @RequestParam("status") RStatus status){
        restaurantService.updateStatus(id, status);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
