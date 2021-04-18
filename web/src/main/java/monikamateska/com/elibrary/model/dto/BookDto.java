package monikamateska.com.elibrary.model.dto;

import lombok.Data;
import monikamateska.com.elibrary.model.enumerations.Category;


@Data
public class BookDto {

    private String name;

    private Long authorId;

    private Category category;

    private Integer availableCopies;

    public BookDto(String name, Long authorId, Category category, Integer availableCopies) {
        this.name = name;
        this.authorId = authorId;
        this.category = category;
        this.availableCopies = availableCopies;
    }

    public BookDto() {
    }

    public String getName() {
        return name;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public Category getCategory() {
        return category;
    }

    public Integer getAvailableCopies() {
        return availableCopies;
    }
}
