package alik.exerciseproject.controller;

import alik.exerciseproject.dto.BookDTO;
import alik.exerciseproject.dto.BookRequest;
import alik.exerciseproject.model.Book;
import alik.exerciseproject.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<BookDTO> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    ResponseEntity<Void> addBook(@RequestBody @Valid BookRequest request) {
        bookService.addBook(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
