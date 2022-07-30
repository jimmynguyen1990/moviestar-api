package com.training.moviestarapi.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "genres")
public class Genre {

	//Attributes
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "genre")
	private String genre;
	
	@Column(name = "genre_image")
	private String genreImage;
	
	//Relationship
	@ManyToMany(fetch = FetchType.LAZY,
				cascade = {CascadeType.DETACH, CascadeType.MERGE,
						   CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "movie_genre",
			   joinColumns = @JoinColumn(name = "genre_id"),
			   inverseJoinColumns = @JoinColumn(name = "movie_id"))
	private List<Movie>movies;

	//Constructor
	public Genre() {
		
	}

	//Getter, setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getGenreImage() {
		return genreImage;
	}

	public void setGenreImage(String genreImage) {
		this.genreImage = genreImage;
	}

//	public List<Movie> getMovies() {
//		return movies;
//	}
//
//	public void setMovies(List<Movie> movies) {
//		this.movies = movies;
//	}

	//ToString method
	@Override
	public String toString() {
		return "Genre [id=" + id + ", genre=" + genre + ", genreImage=" + genreImage + "]";
	}
	
	
	
	
	
	
	
}
