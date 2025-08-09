package alik.exerciseproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReviewRequest {
    private String reviewerName;
    private int rating;
    private String comment;
    private long bookId;
}
