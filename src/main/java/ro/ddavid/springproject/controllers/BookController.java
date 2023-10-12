package ro.ddavid.springproject.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ddavid.springproject.models.entities.Book;
import ro.ddavid.springproject.services.BookService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/books")
public class BookController {

    //create CRUD REST APIs
    private final BookService bookServices;


    public BookController(BookService bookServices) {
        this.bookServices = bookServices;
    }

    @PostMapping()
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookServices.createBook(book));
    }

    @GetMapping()
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookServices.getAllBooks());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> changeBook(@PathVariable UUID id, @RequestBody Book book) {
        return ResponseEntity.ok(bookServices.updateBook(id, book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable UUID id) {
        return ResponseEntity.ok(bookServices.deleteBook(id));
    }
}
