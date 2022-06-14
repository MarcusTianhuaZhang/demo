package com.example.demo.movie;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public void addNewMovie(Movie movie){
        Optional<Movie> findMovieTitle = movieRepository.findMovieTitle(movie.getTitle());
        if (findMovieTitle.isPresent()){
            throw new IllegalArgumentException("movie exists on site");
        }
        movieRepository.save(movie);
    }
}
