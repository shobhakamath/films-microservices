package com.films.service;

import com.films.model.Film;
import com.films.repository.FilmRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmService {
    private FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public Film saveFilm(Film film) {
        return filmRepository.save(film);
    }

    public Iterable<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    public void deleteAllFilms() {
        filmRepository.deleteAll();
    }

    public void deleteFilmById(String id) {
        filmRepository.deleteById(id);
    }

    public Optional<Film> findFilmById(String id) {
        return filmRepository.findById(id);
    }
}
