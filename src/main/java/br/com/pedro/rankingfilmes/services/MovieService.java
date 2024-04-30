package br.com.pedro.rankingfilmes.services;

import br.com.pedro.rankingfilmes.dtos.MovieDTO;
import br.com.pedro.rankingfilmes.models.Movie;
import br.com.pedro.rankingfilmes.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public MovieDTO createMovie(Movie movie) {

       Movie createdMovie = movieRepository.save(movie);

       MovieDTO movieDTO = new MovieDTO(createdMovie);

       return movieDTO;
    }

    public List<MovieDTO> findAllMovies() {
        List<Movie> movies = movieRepository.findAll();

        List<MovieDTO> movieDTOs = new ArrayList<>();

        for (Movie movie : movies) {
            MovieDTO movieDTO = new MovieDTO(movie);
            movieDTOs.add(movieDTO);

        }
        return movieDTOs;
    }

    public MovieDTO findMovieById(Long id) {

        Movie findMovieById = movieRepository.findById(id).get();

        MovieDTO movieDTO = new MovieDTO(findMovieById);

        return movieDTO;
    }

    public MovieDTO update(MovieDTO movieDTO) {

        var entity = movieRepository.findById(movieDTO.getID()).orElseThrow();
        entity.setTitle(movieDTO.getTitle());
        entity.setYear(movieDTO.getYear());
        entity.setGenre(movieDTO.getGenre());
        entity.setDirector(movieDTO.getDirector());


        MovieDTO movieUpdate = new MovieDTO(entity);

        return movieUpdate;
    }

    public void delete(Long id){
        var entity = movieRepository.findById(id).orElseThrow(NoSuchElementException::new);

        movieRepository.delete(entity);

    }


}
