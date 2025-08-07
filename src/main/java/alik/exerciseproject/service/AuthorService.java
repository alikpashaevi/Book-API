package alik.exerciseproject.service;

import alik.exerciseproject.components.MapBook;
import alik.exerciseproject.dto.AuthorDTO;
import alik.exerciseproject.dto.BookDTO;
import alik.exerciseproject.model.Author;
import alik.exerciseproject.repo.AuthorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorService {


    private final AuthorRepo authorRepo;

    private AuthorDTO mapAuthor(Author author) {
        if (author == null) {
            return null;
        }

        List<BookDTO> bookDTOs = author.getBooks().stream()
                .map(MapBook::mapBook)
                .collect(Collectors.toList());

        return new AuthorDTO(
                author.getId(),
                author.getName(),
                author.getBio(),
                bookDTOs
        );
    }
   public List<Author> getAuthors() {
       return authorRepo.findAll();
   }

    public AuthorDTO getAuthorById(long id) {
        Author author = authorRepo.findById(id).get();
        return mapAuthor(author);
    }

    public Author findAuthor(long id) {
        return authorRepo.findById(id).get();
    }



}
