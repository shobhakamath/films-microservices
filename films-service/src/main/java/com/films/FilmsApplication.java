package com.films;

import com.films.model.Film;
import com.films.service.FilmService;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class FilmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilmsApplication.class, args);
    }

 /*@Bean
    public CommandLineRunner dbSeeder(FilmService filmService) {
        return (args) -> {
            log.info("Generating sample data");
            filmService.deleteAllFilms();
            List<String> reservations = Arrays.asList("Movie1", "Movie2", "Movie3", "Movie4", "Movie5");
            reservations.forEach(reservation ->
                filmService.saveFilm(Film.builder()
                    .name(reservation)
                    .releaseDate(LocalDateTime.now())
                    .build()));

            filmService.getAllFilms().forEach(reservation ->
                log.info("Film --> " + reservation.getName() + " ID: " + reservation.getId()));

        };
    }*/

}
