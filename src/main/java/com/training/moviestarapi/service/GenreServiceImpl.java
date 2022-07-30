package com.training.moviestarapi.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.training.moviestarapi.dao.GenreDAO;
import com.training.moviestarapi.entity.Genre;

@Service
public class GenreServiceImpl implements GenreService {

	@Autowired
	private GenreDAO genreDAO;
	
	@Override
	public List<Genre> getAllGenres() {
		
		List<Genre>genres = genreDAO.findAll();
		
		return genres;
	}

}
