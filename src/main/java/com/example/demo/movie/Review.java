package com.example.demo.movie;

import javax.persistence.*;

@Entity
@Table
public class Review {
    @Id
    @SequenceGenerator(
            name = "review_sequence",
            sequenceName = "review_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy =GenerationType.SEQUENCE,
            generator = "review_sequence"
    )
    private Long ID;
    //@OneToOne(mappedBy = "title")
    private String title;
    private boolean like;


    public Review(String title, boolean like) {

        this.title = title;
        this.like = like;
    }

    public Review() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }
}
