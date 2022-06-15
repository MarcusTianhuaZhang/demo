package com.example.demo.movie;


import com.example.demo.review.Review;
import com.example.demo.review.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final ReviewRepository reviewRepository;


    @Autowired
    public MovieService(MovieRepository movieRepository, ReviewRepository reviewRepository) {
        this.movieRepository = movieRepository;
        this.reviewRepository = reviewRepository;
    }


    public List<Movie> getMovie() {
        return movieRepository.findAll();
    }

    public Movie getMovieByTitle(String title) {
        return movieRepository.findById(title).orElseThrow(
                () ->  new NoSuchElementException("Movie with title " + title + " is not found."));
    }


    public void addNewMovie(Movie movie){
        Optional<Movie> findMovieTitle = movieRepository.findMovieTitle(movie.getTitle());
        if (findMovieTitle.isPresent()){
            throw new IllegalArgumentException("movie exists on site");
        }
        movieRepository.save(movie);
    }
    //title serves as the ID of movie
    public void deleteMovie(String title) {
        boolean exists = movieRepository.existsById(title);
        if(!exists){
            throw new IllegalArgumentException(
                    "movie " + title + "does not exist");
        }
        movieRepository.deleteById(title);
    }
    public void addNewReview(Review review) {
        Movie movie = review.getMovie();
        boolean exists = movieRepository.existsById(movie.getTitle());
        if(!exists){
            throw new IllegalArgumentException(
                    "movie " + movie.getTitle() + "cannot be reviewed because it does not exist");
        }
        reviewRepository.save(review);
    }
}
