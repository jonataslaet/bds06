package com.devsuperior.movieflix.controllers.dtos;

import javax.validation.constraints.NotBlank;

import com.devsuperior.movieflix.entities.Review;

public class ReviewDTO {

	private Long id;
	
	@NotBlank
	private String text;
	
	private Long movieId;
	
	private UserDTO user;

	public ReviewDTO() {

	}
	
	public ReviewDTO(Review r) {
		this.id = r.getId();
		this.text = r.getText();
		this.movieId = r.getMovie().getId();
		this.user = new UserDTO(r.getUser());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

}
