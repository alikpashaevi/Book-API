package alik.exerciseproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "book")
@SequenceGenerator(name = "book_seq_gen", sequenceName = "book_id_seq", allocationSize = 1)
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(generator = "book_seq_gen", strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();
}
