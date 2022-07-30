package com.training.moviestarapi.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletMapping;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.moviestarapi.entity.Movie;
import com.training.moviestarapi.service.MovieService;

@RestController
@RequestMapping("/api")
public class MovieRestController {

	@Autowired
	private MovieService movieService;

//	@GetMapping("/movies")
//	public ResponseEntity<?>getAllMovies(){
//		
//		List<Movie>movies = movieService.getAllMovies();
//		
//		return new ResponseEntity<>(movies, HttpStatus.OK);
//	}

	@GetMapping("/movies")
	public ResponseEntity<?> getAllMoviesWithGenres() {

		List<Map<String, ?>> moviesWithGenres = movieService.getAllMoviesWithGenres();

		return new ResponseEntity<>(moviesWithGenres, HttpStatus.OK);
	}

	@GetMapping("/movies/{title}")
	public ResponseEntity<?> getMovieWithGenreByTitle(
									@PathVariable("title") String theTitle) {

		List<Map<String, ?>>moviesWithGenres 
								= movieService.getMovieWithGenreByTitle(theTitle);

		return new ResponseEntity<>(moviesWithGenres, HttpStatus.OK);
	}

	@GetMapping("/genres/{genres}")
	public ResponseEntity<?>getMovieWithGenreByGenre(
									@PathVariable("genres") String theGenre){
		
		List<Map<String, ?>>moviesWithGenres
								= movieService.getMovieWithGenreByGenre(theGenre);
		
		return new ResponseEntity<>(moviesWithGenres, HttpStatus.OK);
	}
	
	private String readDataFromUrl(String theInputURL) {

		String finalUrl = null;

		try {
			URL theURL = new URL(theInputURL);
			HttpURLConnection connetion = (HttpURLConnection) theURL.openConnection();
			connetion.setRequestMethod("GET");

			finalUrl = connetion.toString();
		

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return finalUrl;
	}
}
