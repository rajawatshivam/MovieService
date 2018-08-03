package com.stackroute.movieboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.stackroute.movieboot.domain.Movie;
import com.stackroute.movieboot.exception.MovieNotFoundException;
import com.stackroute.movieboot.repository.MovieRepository;

@Service
@Primary
public class MovieServicesDummyImpl implements MovieService {

	private MovieRepository movieRepository;

	@Autowired
	public MovieServicesDummyImpl(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	@Override
	public Movie saveMovie(Movie movie) {
		System.out.println("hello");
		return null;
	}

	@Override
	public List<Movie> getAllMovies() {
		System.out.println("getting all movies");
		return null;
	}

	@Override
	public Boolean deleteMovieById(int movieId) {
		System.out.println("deleted movies");
		return null;
	}

	@Override
	public Movie updateMovie(int movieId, Movie movie) {
		System.out.println(movieId);
		return null;
	}

	@Override
	public Movie getMovieById(int movieId) throws MovieNotFoundException {
		System.out.println("getting movies by id");
		return null;
	}

	@Override
	public List<Movie> getMovieByTitle(String movieTitle) {
		System.out.println("getting by title");
		return null;
	}

}
