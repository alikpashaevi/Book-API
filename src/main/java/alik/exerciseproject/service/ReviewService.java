package alik.exerciseproject.service;


import alik.exerciseproject.dto.ReviewRequest;
import alik.exerciseproject.model.Review;
import alik.exerciseproject.repo.ReviewRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepo reviewRepo;
    private final BookService bookService;

    public void addReview(ReviewRequest request) {
        Review review = new Review();
        review.setReviewerName(request.getReviewerName());
        review.setRating(request.getRating());
        review.setComment(request.getComment());
        review.setBook(bookService.findBook(request.getBookId()));
        reviewRepo.save(review);
    }

}
