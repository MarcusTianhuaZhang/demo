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
    public List<Movie> getMovie() {
        //return movieService.getMovie();
        return movieService.getMovie();
    }
    @PostMapping
    public void addNewMovie(@RequestBody Movie movie){

        movieService.addNewMovie(movie);
    }
}
