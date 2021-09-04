package com.devsuperior.movieflix.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.controllers.dtos.GenreDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.repositories.GenreRepository;

@Service
public class GenreService {

	@Autowired
	private GenreRepository genreRepository;

	public List<GenreDTO> findAllGenres() {
		List<Genre> genres = genreRepository.findAll();
		return genres.stream().map(g -> new GenreDTO(g)).collect(Collectors.toList());
	}
}
