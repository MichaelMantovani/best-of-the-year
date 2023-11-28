package org.java.spring.controller;


import java.util.ArrayList;
import java.util.List;

import org.java.spring.pojo.Movie;
import org.java.spring.pojo.Song;
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

	private List<Movie> getBestMovies() {
		Movie killers = new Movie(1, "Killers of the flower moon");
		Movie oppenheimer = new Movie(2, "Oppenheimer");
		Movie ioCapitano = new Movie(2, "Io Capitano");
		
		List<Movie> bestMovies = new ArrayList<>();
		bestMovies.addAll(List.of(killers,oppenheimer,ioCapitano));
		
		return bestMovies;

	}
	
	private String getBestSongs() {
		Song[] songs = new Song[3];
		songs[0] = new Song(1, "Dogozilla");
		songs[1] = new Song(2, "Milano Roma pt.II");
		songs[2] = new Song(2, "When I B On Tha Mic");

		return songs[0].getTitle() + " , " + songs[1].getTitle() + " , " + songs[2].getTitle();
	}

	@GetMapping("/movies")
	public String getMoviesPage(Model model) {
		List<Movie> movies = getBestMovies();
		String bestMovies = "";
		int index = 0;
		for (Movie movie : movies) {
			if(index == movies.size() -1 )
			bestMovies += movie.getTitle();
			else
				bestMovies += movie.getTitle() + " , ";
			index++;
		}
		model.addAttribute("movies", bestMovies);
		return "movies";
	}
	
	@GetMapping("/songs")
	public String getSongsPage(Model model) {
		final String songs = getBestSongs();
		model.addAttribute("songs", songs);
		return "songs";
	}

}
