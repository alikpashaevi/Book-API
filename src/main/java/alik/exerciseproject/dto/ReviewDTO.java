package alik.exerciseproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReviewDTO {
    private int id;
    private String reviewerName;
    private int rating;
    private String comment;
    private BookDTO book;
}
