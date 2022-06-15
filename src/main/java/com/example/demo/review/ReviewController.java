package com.example.demo.review;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/movie/like")
public class ReviewController {


//    @PostMapping
//    public void addNewReview(@RequestBody Review review){
//
//        movieService.addNewReview(review);
//    }
}
