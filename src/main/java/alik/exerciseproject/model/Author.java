package alik.exerciseproject.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
@SequenceGenerator(name = "author_seq_gen", sequenceName = "author_id_seq", allocationSize = 1)
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue(generator = "author_seq_gen", strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "bio")
    private String bio;

    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();
}
