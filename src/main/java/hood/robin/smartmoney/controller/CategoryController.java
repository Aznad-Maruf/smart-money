package hood.robin.smartmoney.controller;

import hood.robin.smartmoney.command.CategoryCommand;
import hood.robin.smartmoney.entity.Category;
import hood.robin.smartmoney.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
public class CategoryController extends BaseController<Category> {

    public CategoryController(CategoryService categoryService) {
        super(categoryService);
    }

}
