package com.example.demo.review;

import com.example.demo.movie.Movie;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
public class Review {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    private int likes;
    private int dislikes;


    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "title", insertable=false, updatable=false)
    private Movie movie;

    public Review(Movie movie, boolean like) {
        this.movie = movie;
        //this.movie_title = movie_title;
        if(like){
            this.likes = 1;
            this.dislikes = 0;
        }else{
            this.likes = 0;
            this.dislikes = 1;
        }
    }

    public Review() {
    }
//
//    public String getMovie_title() {
//        return movie_title;
//    }
//
//    public void setMovie_title(String movie_title) {
//        this.movie_title = movie_title;
//    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}


