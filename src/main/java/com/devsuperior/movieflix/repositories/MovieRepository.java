package com.devsuperior.movieflix.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

	@Query("SELECT DISTINCT mov FROM Movie mov INNER JOIN mov.genre g "
			+ "WHERE (COALESCE(:genres) IS NULL OR g IN :genres) ORDER BY mov.title")
	Page<Movie> find(List<Genre> genres, Pageable pageable);

}
