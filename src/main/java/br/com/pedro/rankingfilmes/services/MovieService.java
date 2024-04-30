package br.com.pedro.rankingfilmes.services;

import br.com.pedro.rankingfilmes.dtos.MovieDTO;
import br.com.pedro.rankingfilmes.models.Movie;
import br.com.pedro.rankingfilmes.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public MovieDTO createMovie(Movie movie) {

       Movie createdMovie = movieRepository.save(movie);

       MovieDTO movieDTO = new MovieDTO(createdMovie);

       return movieDTO;
    }
}
