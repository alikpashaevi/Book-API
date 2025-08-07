package alik.exerciseproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDTO {
    private long id;
    private String title;
    private String description;
    private String author;
    private ReviewForBook review;
}
