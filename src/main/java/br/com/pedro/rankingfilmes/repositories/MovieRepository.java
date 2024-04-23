package br.com.pedro.rankingfilmes.repositories;

import br.com.pedro.rankingfilmes.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> { }
