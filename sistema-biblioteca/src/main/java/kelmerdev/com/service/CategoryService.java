package kelmerdev.com.service;

import kelmerdev.com.dto.CategoryDTO;
import kelmerdev.com.entity.Category;

public interface CategoryService {
    Category create(CategoryDTO categoryDTO);
}
