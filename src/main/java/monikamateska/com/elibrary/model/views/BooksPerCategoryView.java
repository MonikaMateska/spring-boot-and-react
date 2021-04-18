package monikamateska.com.elibrary.model.views;

import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Subselect("SELECT * FROM public.books_per_category")
@Immutable
public class BooksPerCategoryView {

    @Id
    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "num_books")
    private Integer numBooks;
}
