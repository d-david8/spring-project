package ro.ddavid.springproject.services;

import ro.ddavid.springproject.models.Book;

import java.util.List;
import java.util.UUID;

public interface BookService {

    Book createBook(Book book);

    List<Book> getAllBooks();

    Book updateBook(UUID id, Book book);

    Book deleteBook(UUID id);
}
