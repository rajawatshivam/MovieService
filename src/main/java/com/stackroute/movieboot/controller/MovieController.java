package com.stackroute.movieboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.movieboot.domain.Movie;
import com.stackroute.movieboot.exception.MovieNotFoundException;
import com.stackroute.movieboot.services.MovieService;
import com.stackroute.movieboot.services.MovieServicesImpl;

@RestController
@RequestMapping("/api/v1/")
public class MovieController {
	
	@Qualifier("MovieServicesDummyImpl")
	@Autowired
	private MovieService movieService;

	@Autowired
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}

	@RequestMapping(value = "/movie", method = RequestMethod.POST, produces = ("application/json"))
	public ResponseEntity<?> saveMovie(@RequestBody Movie movie) {
		Movie savedMovie = movieService.saveMovie(movie);
		return new ResponseEntity<Movie>(savedMovie, HttpStatus.OK);

	}

	@RequestMapping(value = "/movies", method = RequestMethod.GET, produces = ("application/json"))
	public ResponseEntity<?> getAllMovies() {
		List<Movie> movies = movieService.getAllMovies();
		return new ResponseEntity<List>(movies, HttpStatus.OK);
	}

	@RequestMapping(value = "/movie/{movieId}", method = RequestMethod.DELETE, produces = ("application/json"))
	public ResponseEntity<?> deleteById(@PathVariable int movieId) {
		Boolean movie = movieService.deleteMovieById(movieId);
		if (movie) {
			return new ResponseEntity<String>("deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("not deleted", HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(value = "/movie/{movieId}", method = RequestMethod.PUT, produces = ("application/json"))
	public ResponseEntity<?> updateMovie(@PathVariable int movieId, @RequestBody Movie movie) {
		Movie updatedMovie = movieService.updateMovie(movieId, movie);
		return new ResponseEntity<Movie>(updatedMovie, HttpStatus.OK);
	}

	@RequestMapping(value = "/movie/{movieId}", method = RequestMethod.GET)
	public ResponseEntity<?> getMovieById(@PathVariable int movieId) {

		Movie movieObj = null;
		try {
			movieObj = movieService.getMovieById(movieId);
		} catch (MovieNotFoundException ex) {
			String result = ex.getMessage();
			return new ResponseEntity<String>(result, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Movie>(movieObj, HttpStatus.OK);
	}

	@RequestMapping(value = "searchName/movie/{mname}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getMovieByTitle(@PathVariable String mname) {
		List<Movie> movieList = movieService.getMovieByTitle(mname);
		if (!movieList.isEmpty())
			return new ResponseEntity<List<Movie>>(movieList, HttpStatus.OK);
		else
			return new ResponseEntity<String>("Movie not present by that name", HttpStatus.NOT_FOUND);
	}
	// @RequestMapping(value="sNBR/movie/{mname}" , method=RequestMethod.GET ,
	// produces="application/json")
	// public ResponseEntity<?> getMovieByRating(@PathVariable String movieRating){
	// List<Movie> movieList = movieService.getMovieByRating(movieRating);
	// return new ResponseEntity<List<Movie>>(movieList,HttpStatus.OK);
	// }
}
