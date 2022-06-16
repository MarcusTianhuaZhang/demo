package com.example.demo.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository
        extends JpaRepository<Movie, String> {

    @Query("Select m FROM Movie m Where m.title = ?1")
    Optional<Movie> findMovieTitle(String title);
}
