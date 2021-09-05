package com.devsuperior.movieflix.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.controllers.dtos.MovieDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private GenreRepository genreRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	

	public Page<MovieDTO> findAllPagedMoviesByGenreOrderedByName(Long genreId, Pageable pageable) {
		List<Genre> genres = null;
		Genre genre = null;
		
		Optional<Genre> genreOptional = genreId == 0 ? Optional.empty() : genreRepository.findById(genreId);
		if (genreOptional.isPresent()) {
			genre = genreOptional.get();
			genres = new ArrayList<>();
			genres.add(genre);
		}
		Page<Movie> moviesPaged = movieRepository.find(genres, pageable);
		return moviesPaged.map(c -> new MovieDTO(c));
	}


	public MovieDTO findMovieById(Long id) {
		Movie movie = new Movie();
		
		Optional<Movie> movieOptional = movieRepository.findById(id);
		movieOptional.orElseThrow(() -> new EntityNotFoundException("Movie not found"));
		
		movie = movieOptional.get();
//		Optional<Genre> genreOptional = genreRepository.findById(genreId);
		
		return new MovieDTO(movie, movie.getReviews());
	}

}
