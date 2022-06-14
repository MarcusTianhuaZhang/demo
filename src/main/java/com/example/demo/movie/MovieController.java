package com.example.demo.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/movie")
public class MovieController {

    private final MovieService movieService;
    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getMovie(@RequestParam(required = false) final String title) {
        if (title != null) {
            return List.of(movieService.getMovieByTitle(title));
        } else {
            return movieService.getMovie();}
    }

    @PostMapping
    public void addNewMovie(@RequestBody Movie movie){

        movieService.addNewMovie(movie);
    }
    @DeleteMapping(path = "{movieTitle}")
    public void deleteMovie(@PathVariable("movieTitle") String title){
        movieService.deleteMovie(title);
    }
}
