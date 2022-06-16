package com.example.demo.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    //support searching movie by title
    @GetMapping
    public List<Movie> getMovie(@RequestParam(required = false) final String title) {
        if (title != null) {
            return List.of(movieService.getMovieByTitle(title));
        } else {
            return movieService.getMovie();
        }
    }

    @PostMapping
    public void addNewMovie(@RequestBody Movie movie) {
        movieService.addNewMovie(movie);
    }

    @PutMapping(path = "{movieTitle}")
    public void updateMovie(
            @PathVariable("movieTitle") String title,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) Integer releaseYear,
            @RequestParam(required = false) Double duration) {
        movieService.updateMovie(title, description, releaseYear, duration);
    }

    @PutMapping(path = "/{movieTitle}/like")
    public void likeMovie(@PathVariable("movieTitle") String title) {
        movieService.likeMovie(title);
    }

    @DeleteMapping(path = "/delete/{movieTitle}")
    public void deleteMovie(@PathVariable("movieTitle") String title) {
        movieService.deleteMovie(title);
    }
}
