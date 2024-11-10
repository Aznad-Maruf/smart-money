package hood.robin.smartmoney.controller;

import hood.robin.smartmoney.command.CategoryCommand;
import hood.robin.smartmoney.entity.Category;
import hood.robin.smartmoney.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAll(){
        // TODO Add pagination
        List<Category> categories = categoryService.findAll();

        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<Category> save(@RequestBody @Valid CategoryCommand command) {
        Category category = categoryService.save(getCategory(command));

        return ResponseEntity.ok(category);
    }

    private Category getCategory(CategoryCommand command) {
        Category category = new Category();
        category.setUuid(UUID.randomUUID());
        category.setName(command.getName());
        category.setDescription(command.getDescription());

        return category;
    }

}
