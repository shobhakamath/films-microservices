package com.films.controller;

import com.films.model.Film;
import com.films.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/films")
@RestController
public class FilmController {
    @Autowired
    private FilmService filmService;

    @GetMapping
    public Iterable<Film> getAllFilms() {
        return filmService.getAllFilms();
    }

    @PostMapping
    public Film postFilms(@RequestBody Film film) {
        return filmService.saveFilm(film);
    }

}
