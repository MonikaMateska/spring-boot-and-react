package monikamateska.com.elibrary.service.impl;

import monikamateska.com.elibrary.model.enumerations.Category;
import monikamateska.com.elibrary.repository.CategoryRepository;
import monikamateska.com.elibrary.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }
}
