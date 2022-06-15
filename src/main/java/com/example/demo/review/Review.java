package com.example.demo.review;

import com.example.demo.movie.Movie;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table
public class Review {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(
            name = "review_sequence",
            sequenceName = "review_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy =GenerationType.SEQUENCE,
            generator = "review_sequence"
    )
    private Long id;
    //private String movie_title;
    private boolean like;


//    @OneToOne(fetch = FetchType.LAZY)
//    @MapsId

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "movie", insertable=false, updatable=false)
    private Movie movie;

    public Review(Movie movie, boolean like) {
        this.movie = movie;
        this.like = like;
        //this.movie_title = movie_title;
//        if(like){
//            this.likes = 1;
//            this.dislikes = 0;
//        }else{
//            this.likes = 0;
//            this.dislikes = 1;
//        }
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}


