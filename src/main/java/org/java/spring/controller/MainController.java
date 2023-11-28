package org.java.spring.controller;

import org.java.spring.pojo.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String home(Model model) {
		final String username = "Michael";
		model.addAttribute("username", username);
		return "home";
	}

	private String getBestMovies() {
		Movie[] movies = new Movie[3];
		movies[0] = new Movie(1, "Killers of the flower moon");
		movies[1] = new Movie(2, "Oppenheimer");
		movies[2] = new Movie(2, "Io Capitano");

		return movies[0].getTitle() + " , " + movies[1].getTitle() + " , " + movies[2].getTitle();
	}

	@GetMapping("/movies")
	public String getMovies(Model model) {
		final String movies = getBestMovies();
		model.addAttribute("movies", movies);
		return "movies";
	}

}
