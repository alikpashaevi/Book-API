package alik.exerciseproject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookRequest {
    @NotBlank
    private String title;
    @Size(min = 2, max = 100)
    private String description;
    @Positive
    private long authorId;
}
