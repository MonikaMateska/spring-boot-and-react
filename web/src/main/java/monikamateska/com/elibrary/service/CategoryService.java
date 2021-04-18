package monikamateska.com.elibrary.service;

import monikamateska.com.elibrary.model.enumerations.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();
}
