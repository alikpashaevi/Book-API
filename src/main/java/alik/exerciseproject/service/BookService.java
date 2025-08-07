package alik.exerciseproject.service;

import alik.exerciseproject.components.MapBook;
import alik.exerciseproject.dto.BookDTO;
import alik.exerciseproject.dto.BookRequest;
import alik.exerciseproject.dto.ReviewDTO;
import alik.exerciseproject.dto.ReviewForBook;
import alik.exerciseproject.model.Book;
import alik.exerciseproject.repo.BookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepo bookRepo;
    private final AuthorService authorService;


    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public BookDTO getBookById(int id) {
        Book book = bookRepo.findById(id).get();
        return MapBook.mapBook(book);
    }

    public void addBook(BookRequest request) {
        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setDescription(request.getDescription());
        book.setAuthor(authorService.findAuthor(request.getAuthorId()));
        bookRepo.save(book);
    }

}
