package com.devsuperior.movieflix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.controllers.dtos.MovieDTO;
import com.devsuperior.movieflix.services.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping
	ResponseEntity<Page<MovieDTO>> findAllPagedMoviesOrderedByGenre (
			@RequestParam(value = "genreId", defaultValue = "0") Long genreId,
			Pageable pageable) {
		Page<MovieDTO> moviesDTO = movieService.findAllPagedMoviesByGenreOrderedByName(genreId, pageable);

		return ResponseEntity.ok().body(moviesDTO);
	}
	
	@PreAuthorize("hasAnyRole('VISITOR','MEMBER')")
	@GetMapping(value = "/{id}")
	ResponseEntity<MovieDTO> findMovieById (@PathVariable("id") Long id) {
		MovieDTO movieDTO = movieService.findMovieById(id);

		return ResponseEntity.ok().body(movieDTO);
	}

}