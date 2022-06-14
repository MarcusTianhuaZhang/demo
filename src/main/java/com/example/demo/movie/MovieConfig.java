package com.example.demo.movie;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MovieConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            MovieRepository repository){
        return args -> {
            Movie shrek = new Movie("Shrek",
                    "good movie",
                    2005,
                    135,
                    8.2
            );
            Movie interstellar = new Movie("Interstellar",
                    "super good movie",
                    2015,
                    135,
                    9.2
            );
            repository.saveAll(
                    List.of(shrek, interstellar)
            );
        };
    }

}
