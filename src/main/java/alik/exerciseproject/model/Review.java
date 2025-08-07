package alik.exerciseproject.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "review")
@SequenceGenerator(name = "review_seq_gen", sequenceName = "review_id_seq", allocationSize = 1)
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue(generator = "review_seq_gen", strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "review_name")
    private String reviewName;

    @Column(name = "rating")
    private int rating;

    @Column(name = "comment")
    private String comment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private Book book;

}
