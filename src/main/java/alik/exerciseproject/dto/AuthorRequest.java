package alik.exerciseproject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthorRequest {
    @NotBlank
    @Size(min = 2, max = 50)
    private String name;
    @Size(min = 10, max = 100)
    private String bio;
    @Positive
    private long bookId;
}
