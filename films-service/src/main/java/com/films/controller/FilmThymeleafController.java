package com.films.controller;

import com.films.model.Film;
import com.films.service.FilmService;
import java.security.Principal;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FilmThymeleafController {

    private FilmService filmService;

    @Autowired
    public FilmThymeleafController(FilmService filmService) {
        this.filmService = filmService;
    }

    @RequestMapping("/films-ui")
    public ModelAndView getFilms() {
        ModelAndView modelAndView = new ModelAndView("films");
        Iterable<Film> films = filmService.getAllFilms();
        modelAndView.addObject("films", films);
        return modelAndView;
    }
    @GetMapping("/delete-film/{id}")
    public String removeFilm(@PathVariable("id") String id, Model model) {
        filmService.deleteFilmById(id);
        model.addAttribute("films", filmService.getAllFilms());
        return "films";
    }
   // @Secured("ROLE_ADMIN")
    @GetMapping(value = {"/edit-add-film/{id}", "/edit-add-film"})
    public String editFilm(@PathVariable("id") Optional<String> id, Model model) {
        Film film = id.isPresent() ?
                filmService.findFilmById(id.get()).get() : new Film();
        model.addAttribute("film", film);
        return "add-edit";
    }
    @Secured("ROLE_ADMIN")
    @PostMapping("/save-film")
    public String addFilm(@ModelAttribute("film") @Valid Film film,
                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add-edit";
        }
        filmService.saveFilm(film);
        return "redirect:films-ui";
    }

    @RequestMapping("/review/{filmId}")
    public String join(@PathVariable String filmId, Principal principal) {
        ModelAndView modelAndView = new ModelAndView("review");
        modelAndView.addObject("film", filmService.findFilmById(filmId));
        modelAndView.addObject("user",principal.getName());
        return "redirect:http://localhost:8080";
    }
}
