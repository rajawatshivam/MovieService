package com.stackroute.movieboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import com.stackroute.movieboot.domain.Movie;
import com.stackroute.movieboot.repository.MovieRepository;

@Configuration
public class BootStrapData implements ApplicationListener<ContextRefreshedEvent> {

	private MovieRepository movieRepository;
	private Movie movie;

	@Autowired
	public BootStrapData(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Movie movie = new Movie();
		movie.setMovieId(1);
		movie.setMovieTitle("logan");
		movie.setMovieRating("five");
		movie.setYearOfRelease(2018);
		movieRepository.save(movie);
		Movie testMovie = Movie.builder()
							.movieId(1)
				 			.movieTitle("foo")
				 			.movieRating("five")
				 		    .yearOfRelease(2018)
				 			.build();
		movieRepository.save(testMovie);
	}

}
