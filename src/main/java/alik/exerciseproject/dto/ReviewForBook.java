package alik.exerciseproject.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReviewForBook {
    private long id;
    private String reviewName;
    private int rating;
    private String comment;
    private String book;
}
