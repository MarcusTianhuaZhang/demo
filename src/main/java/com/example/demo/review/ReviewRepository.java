package com.example.demo.review;

import com.example.demo.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review,String> {

    @Query("select r from Review r join fetch r.movie where r.movie.title = ?1")
    public Review findReview(String movie_title);
}
