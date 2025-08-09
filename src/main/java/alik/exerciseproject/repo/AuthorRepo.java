package alik.exerciseproject.repo;

import alik.exerciseproject.dto.AuthorDTO;
import alik.exerciseproject.model.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepo  extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a JOIN FETCH a.books b")
    Page<Author> findAuthors(Pageable pageable);


}
