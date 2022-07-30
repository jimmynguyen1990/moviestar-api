package com.training.moviestarapi.service;

import java.util.List;
import java.util.Map;

import com.training.moviestarapi.entity.Movie;

public interface MovieService {

	public List<Map<String, ?>>getAllMoviesWithGenres();
	
	public List<Map<String, ?>>getMovieWithGenreByTitle(String theTitle);
	
	public List<Map<String, ?>>getMovieWithGenreByGenre(String theGenre);
}
