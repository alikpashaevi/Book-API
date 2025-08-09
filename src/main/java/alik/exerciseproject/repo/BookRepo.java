package alik.exerciseproject.repo;

import alik.exerciseproject.dto.BookDTO;
import alik.exerciseproject.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

    @Query("SELECT new alik.exerciseproject.dto.BookDTO(b.id, b.title, b.description, a.name, " +
            "new alik.exerciseproject.dto.ReviewForBook(r.id, r.reviewerName, r.rating, r.comment, r.book.title)) " +
            "FROM Book b " +
            "JOIN b.author a " +
            "LEFT JOIN b.reviews r")
    List<BookDTO> findBooks();



}
