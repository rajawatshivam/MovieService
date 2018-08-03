package com.stackroute.movieboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.stackroute.movieboot.domain.Movie;
import com.stackroute.movieboot.exception.MovieNotFoundException;
import com.stackroute.movieboot.repository.MovieRepository;

@Service
@Primary
public class MovieServicesImpl implements MovieService {
	
	private MovieRepository movieRepository;

	@Autowired
	public MovieServicesImpl(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	@Override
	public Movie saveMovie(Movie movie) {
		Movie savedMovie = movieRepository.save(movie);
		return savedMovie;
	}

	@Override
	public List<Movie> getAllMovies() {
		List<Movie> movies = (List<Movie>) movieRepository.findAll();
		return movies;
	}

	@Override
	public Boolean deleteMovieById(int movieId) {
		movieRepository.deleteById(movieId);
		return true;
	}

	@Override
	public Movie updateMovie(int movieId, Movie movie) {
		movie.setMovieId(movieId);
		movieRepository.save(movie);
		return movie;
	}

	@Override
	public Movie getMovieById(int movieId) throws MovieNotFoundException {
		Optional<Movie> movieObj = movieRepository.findById(movieId);
		if (!(movieObj.isPresent())) {
			throw new MovieNotFoundException(" Entered movie is not present,enter valid movie id" + movieId);
		}
		return movieObj.get();
	}
	// @Override
	// public Movie getMovieByTitle(String movieTitle) {
	// Optional<Movie> movie=movieRepository.findById(movieTitle);
	// return movie.get();
	// }
//	@Override
//	public List<Movie> getMovieByTitle(String movieTitle) {
//		List<Movie> movieList = movieRepository.getMovieByTitle(movieTitle);
//		return movieList;
//	}

	// @Override
	// public List<Movie> getMovieByRating(String movieRating) {
	// List<Movie> movieList=movieRepository.getMoviesByRating(movieRating);
	// return movieList;
	// }

}
