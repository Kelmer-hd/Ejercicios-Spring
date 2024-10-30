package kelmerdev.com.service;

import kelmerdev.com.dto.ProductResponse;
import kelmerdev.com.model.Product;
import lombok.AllArgsConstructor;

import java.util.List;
public interface ProductService {
    List<ProductResponse> findAll();


}
