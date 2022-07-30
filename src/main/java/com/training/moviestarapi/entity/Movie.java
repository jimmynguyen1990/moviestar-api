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
@Table(name = "movies")
public class Movie {

	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "nation_id")
	private int nationId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "sm_image")
	private String smallImage;
	
	@Column(name = "lg_image")
	private String largeImage;
	
	@Column(name = "released_year")
	private int releasedYear;
	
	@Column(name = "descriptions")
	private String descriptions;
	
	//Relationship
	@ManyToMany(fetch = FetchType.LAZY,
				cascade = {CascadeType.DETACH, CascadeType.MERGE,
						   CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "movie_genre",
			   joinColumns = @JoinColumn(name = "movie_id"),
			   inverseJoinColumns = @JoinColumn(name = "genre_id"))
	private List<Genre>genres;

	//Constructor
	public Movie() {
		
	}
	
	//Getter, setter
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNationId() {
		return nationId;
	}

	public void setNationId(int nationId) {
		this.nationId = nationId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSmallImage() {
		return smallImage;
	}

	public void setSmallImage(String smallImage) {
		this.smallImage = smallImage;
	}

	public int getReleasedYear() {
		return releasedYear;
	}

	public void setReleasedYear(int releasedYear) {
		this.releasedYear = releasedYear;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre>genres) {
		this.genres = genres;
	}

	public String getLargeImage() {
		return largeImage;
	}

	public void setLargeImage(String largeImage) {
		this.largeImage = largeImage;
	}

	//ToString method
	@Override
	public String toString() {
		return "Movie [id=" + id + ", nationId=" + nationId + ", title=" + title + ", smallImage=" + smallImage
				+ ", largeImage=" + largeImage + ", releasedYear=" + releasedYear + ", descriptions=" + descriptions
				+ ", genres=" + genres + "]";
	}

	


	

	
	
	
}
