package com.example.demo.movie;


import com.example.demo.review.Review;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Movie {
    @Id
//    @SequenceGenerator(
//            name = "movie_sequence",
//            sequenceName = "movie_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy =GenerationType.SEQUENCE,
//            generator = "movie_sequence"
//    )
    private String title;
    private String description;
    private Integer releaseYear;
    private Double duration;


    private Integer likes;
    private Integer dislikes;

////    @OneToOne(cascade = CascadeType.ALL)
////    @JoinColumn(name = "movie")
////    private Review review;
//    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<Review> reviews;

    @Transient
    private double rating;

    public Movie(String title, String description, Integer releaseYear, Double duration) {
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.likes = 0;
        this.dislikes = 0;
    }

    public Movie() {
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public Double getDuration() {
        return duration;
    }

    public double getRating() {
        if ((likes + dislikes) == 0){
            return 0.0;
        }
        rating = ((double)likes / (likes + dislikes));
        rating = Math.round(rating * 100.0) / 100.0;
        return rating * 10;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getDislikes() {
        return dislikes;
    }

    public void setDislikes(Integer dislikes) {
        this.dislikes = dislikes;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", releaseYear=" + releaseYear +
                ", duration=" + duration +
                ", rating=" + rating +
                '}';
    }
}
