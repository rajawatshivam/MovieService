package com.stackroute.movieboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stackroute.movieboot.domain.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {

	
	//public Movie getByMovieTitle(String movieTitle);
	//public Movie getByMovieRating(String movieRating);
	//public Movie findById(String movieTitle);
	@Query("SELECT m FROM Movie m WHERE m.movieTitle LIKE :movieTitle%")
	public List<Movie> getMovieByTitle(@Param("movieTitle") String movieTitle);
	
//	@Query("SELECT m FROM Movie m WHERE m.movieRating LIKE :movieRating%")
//	public List<Movie> getMoviesByRating(@Param("movieRating") String movieRating);
}
