package monikamateska.com.elibrary.repository;

import monikamateska.com.elibrary.model.enumerations.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
