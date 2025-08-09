package alik.exerciseproject.service;

import alik.exerciseproject.components.MapBook;
import alik.exerciseproject.dto.AuthorDTO;
import alik.exerciseproject.dto.BookDTO;
import alik.exerciseproject.model.Author;
import alik.exerciseproject.repo.AuthorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
   public Page<AuthorDTO> getAuthors(int page, int pageSize) {
        Page<Author> authors = authorRepo.findAuthors(PageRequest.of(page, pageSize));
       return authors.map(this::mapAuthor);
   }

    public AuthorDTO getAuthorById(long id) {
        Author author = authorRepo.findById(id).get();
        return mapAuthor(author);
    }

    public Author findAuthor(long id) {
        return authorRepo.findById(id).get();
    }



}
