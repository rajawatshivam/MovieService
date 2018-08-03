package com.stackroute.movieboot.services;

import java.util.List;

import com.stackroute.movieboot.domain.Movie;
import com.stackroute.movieboot.exception.MovieNotFoundException;

public interface MovieService {

	public Movie saveMovie(Movie movie);

	public List<Movie> getAllMovies();
	
	public Boolean deleteMovieById(int movieId);

	public Movie updateMovie(int movieId, Movie movie);

	public Movie getMovieById(int movieId) throws MovieNotFoundException;

	public List<Movie> getMovieByTitle(String movieTitle);

	//public List<Movie> getMovieByRating(String movieRating);
}
