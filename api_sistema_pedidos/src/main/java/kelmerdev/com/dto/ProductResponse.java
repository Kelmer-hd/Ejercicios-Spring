package kelmerdev.com.dto;

import kelmerdev.com.model.PCategoria;
import lombok.Data;

@Data
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private double price;
    private PCategoria category;
    private boolean isAvailable;
    private Integer preparationTime;
}
