package com.films.repository;

import com.films.model.Film;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends MongoRepository<Film, String> {
    Film getFilmByName(String name);
}
