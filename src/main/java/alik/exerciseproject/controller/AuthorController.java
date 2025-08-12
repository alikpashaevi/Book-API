package alik.exerciseproject.controller;

import alik.exerciseproject.dto.AuthorDTO;
import alik.exerciseproject.dto.AuthorRequest;
import alik.exerciseproject.model.Author;
import alik.exerciseproject.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    public Page<AuthorDTO> getAuthors(@RequestParam int page, @RequestParam int pageSize) {
        return authorService.getAuthors(page, pageSize);
    }

    @GetMapping("/{authorId")
    public ResponseEntity<AuthorDTO> getAuthor(@PathVariable int authorId) {
        AuthorDTO author = authorService.getAuthorById(authorId);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AuthorDTO> createAuthor(@RequestBody AuthorRequest request) {
        authorService.addAuthor(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{authorId}")
    public ResponseEntity<AuthorDTO> updateAuthor(@PathVariable long authorId, @RequestBody AuthorRequest request) {
        authorService.updateAuthor(request, authorId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{authorId}")
    public ResponseEntity<AuthorDTO> deleteAuthor(@PathVariable long authorId) {
        authorService.deleteAuthor(authorId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
