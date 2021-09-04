package com.devsuperior.movieflix.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.controllers.dtos.MovieDTO;
import com.devsuperior.movieflix.controllers.dtos.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private ReviewRepository reviewRepository;

	public ReviewDTO insertReview(@Valid ReviewDTO reviewDTO) {
		
		MovieDTO movieDTO = movieService.findMovieById(reviewDTO.getMovieId());
		Movie movie = new Movie(movieDTO);
		Review review = new Review(reviewDTO);
		review.setMovie(movie);
		review.setUser(authService.getAuthenticatedUser());
		movie.getReviews().add(review);
		
		movieRepository.save(movie);
		Review savedReview = reviewRepository.save(review);
		
		return new ReviewDTO(savedReview);
	}

}
