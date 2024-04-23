package br.com.pedro.rankingfilmes.dtos;

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
}
