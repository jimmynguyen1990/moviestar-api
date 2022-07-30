package com.training.moviestarapi.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.training.moviestarapi.dao.MovieDAO;
import com.training.moviestarapi.entity.Movie;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	private MovieDAO movieDAO;
	
		@Override
	public List<Map<String, ?>> getAllMoviesWithGenres() {
		
		return movieDAO.findAllMoviesWithGenres();
	}

	@Override
	public List<Map<String, ?>> getMovieWithGenreByTitle(String theTitle) {
		
		return movieDAO.findMoviesWithVarietiesByTitle(theTitle);
	}

	@Override
	public List<Map<String, ?>> getMovieWithGenreByGenre(String theGenre) {
		
		return movieDAO.findMovieWithGenreByGenre(theGenre);
	}

}
