package com.example.demo.movie;


import javax.persistence.*;

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
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "movie_title")
    private String title;
    private String description;
    private Integer releaseYear;
    private double duration;
    @Transient
    private double rating;

    public Movie(String title, String description, Integer releaseYear, double duration, double rating) {
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.rating = rating;
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

    public double getDuration() {
        return duration;
    }

    public double getRating() {
        return rating;
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

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public void setRating(double rating) {
        this.rating = rating;
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
