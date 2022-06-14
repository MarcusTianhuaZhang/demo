package com.example.demo.movie;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
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
}
