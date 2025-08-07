package alik.exerciseproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AuthorDTO {
    private long id;
    private String name;
    private String bio;
    private List<BookDTO> books;
}
