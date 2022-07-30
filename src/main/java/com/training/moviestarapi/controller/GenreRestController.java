package com.training.moviestarapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.moviestarapi.entity.Genre;
import com.training.moviestarapi.service.GenreService;

@RestController
@RequestMapping("/api")
public class GenreRestController {

	@Autowired
	private GenreService genreService;
	
	@GetMapping("/genres")
	public ResponseEntity<?>getAllGenres(){
		
		List<Genre>genres = genreService.getAllGenres();
		
		return new ResponseEntity<>(genres, HttpStatus.OK);
	}
}
