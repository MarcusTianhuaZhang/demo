package com.example.demo.movie;

import com.example.demo.review.Review;
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

    @PostMapping  (path = "/review/{movieTitle}")
    public void addNewReview(@PathVariable String movieTitle, @RequestBody Boolean like){

        movieService.addNewReview(movieTitle, like);
    }

    @PutMapping(path = "{movieTitle}")
    public void updateMovie(
            @PathVariable("movieTitle") String title,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) Integer releaseYear,
            @RequestParam(required = false) Double duration){
        movieService.updateMovie(title, description,releaseYear,duration);
    }

    @PutMapping(path = "/{movieTitle}/like")
    public void likeMovie( @PathVariable("movieTitle") String title){
        movieService.likeMovie(title);

    }

    @PutMapping(path = "/{movieTitle}/dislike")
    public void dislikeMovie(@PathVariable("movieTitle") String title){
        movieService.dislikeMovie(title);

    }

    @DeleteMapping(path = "/delete/{movieTitle}")
    public void deleteMovie(@PathVariable("movieTitle") String title){
        movieService.deleteMovie(title);
    }
}
