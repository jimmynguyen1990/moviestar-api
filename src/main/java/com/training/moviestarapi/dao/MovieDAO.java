package com.training.moviestarapi.dao;

import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.training.moviestarapi.entity.Movie;

public interface MovieDAO extends JpaRepository<Movie, Long> {

	@Query(value = "call findAllMoviesWithGenres()",
		   nativeQuery = true)
	List<Map<String, ?>>findAllMoviesWithGenres();
	
	@Query(value = "call findMovieWithGenreByTitle(:searchTitle)",
		   nativeQuery = true)
	List<Map<String, ?>>findMoviesWithVarietiesByTitle(
										@Param("searchTitle") String theTitle);
	
	@Query(value = "call findMovieWithGenreByGenre(:searchGenre)",
		   nativeQuery = true)
	List<Map<String, ?>>findMovieWithGenreByGenre(
										@Param("searchGenre")String theGenre);
	
}


