package monikamateska.com.elibrary.model;

import lombok.Data;
import monikamateska.com.elibrary.model.enumerations.Category;

import javax.persistence.*;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Author author;

    private Category category;

    private Integer availableCopies;

    public Book(String name, Author author, Category category, Integer availableCopies) {
        this.name = name;
        this.author = author;
        this.category = category;
        this.availableCopies = availableCopies;
    }

    public Book() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setAvailableCopies(Integer availableCopies) {
        this.availableCopies = availableCopies;
    }
}
