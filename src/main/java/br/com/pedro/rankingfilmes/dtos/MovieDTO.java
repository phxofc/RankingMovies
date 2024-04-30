package br.com.pedro.rankingfilmes.dtos;

import br.com.pedro.rankingfilmes.models.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {

    private Long ID;
    private  String title;
    private  String director;
    private  String year;
    private  String genre;
    private  String rating;

    public MovieDTO(Movie movie){
        this.ID = movie.getID();
        this.title = movie.getTitle();
        this.director = movie.getDirector();
        this.year = movie.getYear();
        this.genre = movie.getGenre();
        this.rating = movie.getRating();


    }
}
