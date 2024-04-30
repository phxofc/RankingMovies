package br.com.pedro.rankingfilmes.controllers;

import br.com.pedro.rankingfilmes.dtos.MovieDTO;
import br.com.pedro.rankingfilmes.models.Movie;
import br.com.pedro.rankingfilmes.repositories.MovieRepository;
import br.com.pedro.rankingfilmes.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieService movieService;

    @PostMapping("/create")
    public ResponseEntity createMovie(@RequestBody Movie movie) {

      var productSave =  this.movieService.createMovie(movie);
      return ResponseEntity.status(HttpStatus.CREATED).body(productSave);
    }

    @GetMapping()
    public ResponseEntity getAllMovies() {

       List<MovieDTO> movies = this.movieService.findAllMovies();

        return ResponseEntity.status(HttpStatus.OK).body(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity getMovieById(@PathVariable Long id) {

        var movie = this.movieService.findMovieById(id);

        return ResponseEntity.status(HttpStatus.OK).body(movie);
    }

    @PutMapping
    public ResponseEntity<MovieDTO> update( @RequestBody MovieDTO dto){

        MovieDTO persisted = movieService.update(dto);

        return ResponseEntity.status(HttpStatus.OK).body(persisted);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity delete( @PathVariable(value = "id") Long id){

        movieService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Product Deleted");
    }

}
