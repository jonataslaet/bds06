package com.devsuperior.movieflix.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.controllers.dtos.GenreDTO;
import com.devsuperior.movieflix.services.GenreService;

@RestController
@RequestMapping("/genres")
public class GenreController {
	
	@Autowired
	private GenreService genreService;
	
	@PreAuthorize("hasAnyRole('VISITOR','MEMBER')")
	@GetMapping
	public ResponseEntity<List<GenreDTO>> findAllGenres(){
		List<GenreDTO> allGenres = genreService.findAllGenres();
		return ResponseEntity.ok(allGenres);
	}

}
