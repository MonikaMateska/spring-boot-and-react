package monikamateska.com.elibrary.service;

import monikamateska.com.elibrary.model.Book;
import monikamateska.com.elibrary.model.dto.BookDto;
import monikamateska.com.elibrary.model.enumerations.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Page<Book> findAllWithPagination(Pageable pageable);

    Optional<Book> findById(Long id);

    Optional<Book> save(BookDto bookDto);

    Optional<Book> edit(Long id, BookDto bookDto);

    void deleteById(Long id);
}
