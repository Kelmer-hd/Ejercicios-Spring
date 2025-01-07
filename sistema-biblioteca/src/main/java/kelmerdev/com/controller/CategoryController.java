package kelmerdev.com.controller;

import jakarta.validation.Valid;
import kelmerdev.com.dto.CategoryDTO;
import kelmerdev.com.entity.Category;
import kelmerdev.com.service.impl.CategoryServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/category")
@AllArgsConstructor
public class CategoryController {
    private CategoryServiceImpl categoryService;

    @PostMapping
    public ResponseEntity<Category> create(@Valid @RequestBody CategoryDTO categoryDTO){
        Category category = categoryService.create(categoryDTO);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }
}
