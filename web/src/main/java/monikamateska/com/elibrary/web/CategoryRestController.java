package monikamateska.com.elibrary.web;

import monikamateska.com.elibrary.model.Book;
import monikamateska.com.elibrary.model.enumerations.Category;
import monikamateska.com.elibrary.service.CategoryService;
import monikamateska.com.elibrary.service.impl.CategoryServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/categories")
public class CategoryRestController {

    private final CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public List<Category> findAll() {
        return this.categoryService.findAll();
    }

}
