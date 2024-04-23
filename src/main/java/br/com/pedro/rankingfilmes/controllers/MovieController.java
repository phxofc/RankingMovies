package br.com.pedro.rankingfilmes.controllers;

import br.com.pedro.rankingfilmes.models.Movie;
import br.com.pedro.rankingfilmes.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @PostMapping("/create")
    public ResponseEntity createMovie(@RequestBody Movie movie) {

      var productSave =  this.movieRepository.save(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(productSave);
    }

}
