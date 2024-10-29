package kelmerdev.com.dto;

import kelmerdev.com.model.RCategory;
import kelmerdev.com.model.RStatus;
import lombok.Data;

import java.time.LocalTime;

@Data
public class RestaurantResponse {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private RCategory category;
    private LocalTime openTime;
    private LocalTime closeTime;
    private RStatus status;
    private double qualification;

}
