package org.java.spring.controller;


import java.util.ArrayList;
import java.util.List;

import org.java.spring.pojo.Movie;
import org.java.spring.pojo.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
		Movie ioCapitano = new Movie(3, "Io Capitano");
		
		List<Movie> bestMovies = new ArrayList<>();
		bestMovies.addAll(List.of(killers,oppenheimer,ioCapitano));
		
		return bestMovies;

	}
	
	private List<Song> getBestSongs() {
		
		Song song1 = new Song(1, "Dogozilla");
		Song  song2 = new Song(2, "Milano Roma pt.II");
		Song song3 = new Song(3, "When I B On Tha Mic");
		
		List<Song> bestSongs = new ArrayList<>();
		bestSongs.addAll(List.of(song1,song2,song3));
		return bestSongs;
	}

	@GetMapping("/movies")
	public String getMoviesPage(Model model) {
		final List<Movie> bestMovies = getBestMovies();
		model.addAttribute("movies", bestMovies);
		return "movies";
	}
	
	@GetMapping("/songs")
	public String getSongsPage(Model model) {
		final List<Song> bestSongs = getBestSongs();
		model.addAttribute("songs", bestSongs);
		return "songs";
	}
	
	@GetMapping("/song/{id}")
	public String getSongDetailPage(Model model, @PathVariable int id) {
		model.getAttribute("id");
		final List<Song> songs = getBestSongs();
		for (Song song : songs) {
			if(song.getId() == id)
				model.addAttribute("song", song);
		}
		return "songDetail";
	}
	
	@GetMapping("/movie/{id}")
	public String getMovieDetailPage(Model model, @PathVariable int id) {
		model.getAttribute("id");
		final List<Movie> movies = getBestMovies();
		for (Movie movie : movies) {
			if(movie.getId() == id)
				model.addAttribute("movie", movie);
		}
		return "movieDetail";
	}
	

}
