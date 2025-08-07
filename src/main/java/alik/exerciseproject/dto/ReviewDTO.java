package alik.exerciseproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReviewDTO {
    private int id;
    private String reviewName;
    private int rating;
    private String comment;
    private BookDTO book;
}
