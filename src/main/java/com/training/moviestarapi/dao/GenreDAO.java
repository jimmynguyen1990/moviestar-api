package com.training.moviestarapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.moviestarapi.entity.Genre;

public interface GenreDAO extends JpaRepository<Genre, Integer> {

}
