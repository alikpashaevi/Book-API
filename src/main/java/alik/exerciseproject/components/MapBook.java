package alik.exerciseproject.components;

import alik.exerciseproject.dto.BookDTO;
import alik.exerciseproject.dto.ReviewForBook;
import alik.exerciseproject.model.Book;

public class MapBook {
    public static BookDTO mapBook(Book book) {
        return new BookDTO(book.getId(), book.getTitle(), book.getDescription(), book.getAuthor().getName(),
                new ReviewForBook(
                        book.getReviews().getFirst().getId(),
                        book.getReviews().getFirst().getReviewName(),
                        book.getReviews().getFirst().getRating(),
                        book.getReviews().getFirst().getComment(),
                        book.getReviews().getFirst().getBook().getTitle()
                )
        );
    }
}
