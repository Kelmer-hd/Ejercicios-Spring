package kelmerdev.com.service.impl;

import kelmerdev.com.dto.CategoryDTO;
import kelmerdev.com.entity.Category;
import kelmerdev.com.repository.CategoryRepository;
import kelmerdev.com.service.CategoryService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService{


    private ModelMapper modelMapper;
    private CategoryRepository categoryRepository;

    @Override
    public Category create(CategoryDTO categoryDTO) {
        Category category = modelMapper.map( categoryDTO, Category.class);
        return  categoryRepository.save(category);
    }
}
