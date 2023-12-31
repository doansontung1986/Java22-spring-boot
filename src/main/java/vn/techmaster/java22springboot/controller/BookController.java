package vn.techmaster.java22springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.java22springboot.dto.BookRequest;
import vn.techmaster.java22springboot.model.Book;
import vn.techmaster.java22springboot.service.BookService;

import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping(path = {"", "/getAllBooks"})
    public ResponseEntity<List<Book>> getBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable String id) {
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> createNewBook(@RequestBody BookRequest bookRequest) {
        String uuid = UUID.randomUUID().toString();
        Book book = new Book(uuid, bookRequest.title(), bookRequest.author(), bookRequest.year());
        bookService.getAllBooks().add(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }
}
