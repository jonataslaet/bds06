package com.devsuperior.movieflix.controllers.dtos;

import java.io.Serializable;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;

public class MovieDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String title;

	private String subTitle;

	private String synopsis;

	private Integer year;

	private String imgUrl;

	private Genre genre;

	public MovieDTO() {

	}

	public MovieDTO(Movie m) {
		this.id = m.getId();
		this.title = m.getTitle();
		this.subTitle = m.getSubTitle();
		this.synopsis = m.getSynopsis();
		this.year = m.getYear();
		this.imgUrl = m.getImgUrl();
		this.genre = m.getGenre();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

}
