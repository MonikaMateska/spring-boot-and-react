package monikamateska.com.elibrary.web;

import monikamateska.com.elibrary.model.Book;
import monikamateska.com.elibrary.model.enumerations.Category;
import monikamateska.com.elibrary.service.BookService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/book")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public List<Book> findAll() {
        return this.bookService.findAll();
    }

    @GetMapping
    public List<Book> findAllWithPagination(Pageable pageable) {
        return this.bookService.findAllWithPagination(pageable).getContent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return this.bookService.findById(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Book> save(@RequestParam String name,
                                     @RequestParam Long authorId,
                                     @RequestParam Category category,
                                     @RequestParam Integer availableCopies) {
        return this.bookService.save(name, authorId, category, availableCopies)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> save(@PathVariable Long id,
                                     @RequestParam String name,
                                     @RequestParam Long authorId,
                                     @RequestParam Category category,
                                     @RequestParam Integer availableCopies) {
        return this.bookService.edit(id, name, authorId, category, availableCopies)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.bookService.deleteById(id);
        if(this.bookService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

}
