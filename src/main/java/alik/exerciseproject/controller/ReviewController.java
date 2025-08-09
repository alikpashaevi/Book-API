package alik.exerciseproject.controller;

import alik.exerciseproject.dto.ReviewRequest;
import alik.exerciseproject.model.Review;
import alik.exerciseproject.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public void addReview(@RequestBody ReviewRequest request) {
        reviewService.addReview(request);
    }

}
