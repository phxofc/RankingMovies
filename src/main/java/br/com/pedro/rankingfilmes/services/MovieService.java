package br.com.pedro.rankingfilmes.services;

import br.com.pedro.rankingfilmes.dtos.MovieDTO;
import br.com.pedro.rankingfilmes.models.Movie;
import br.com.pedro.rankingfilmes.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public MovieDTO createMovie(Movie movie) {

       Movie createdMovie = movieRepository.save(movie);

       MovieDTO movieDTO = new MovieDTO(createdMovie);

       return movieDTO;
    }

    public List<MovieDTO> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();

        List<MovieDTO> movieDTOs = new ArrayList<>();

        for (Movie movie : movies) {
            MovieDTO movieDTO = new MovieDTO(movie);
            movieDTOs.add(movieDTO);

        }
        return movieDTOs;
    }



}
