package monikamateska.com.elibrary.repository.views;

import monikamateska.com.elibrary.model.views.BooksPerCategoryView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksPerCategoryViewRepository extends JpaRepository<BooksPerCategoryView, Long> {
}
