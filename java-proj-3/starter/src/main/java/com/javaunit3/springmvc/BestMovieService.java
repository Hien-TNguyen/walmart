package com.javaunit3.springmvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class BestMovieService {

  private Movie movie;

  @Autowired
  public void BestMovieService(@Qualifier("titanicMovie") Movie theMovie) {
    this.movie = theMovie;
  }

  public Movie getBestMovie() {
    return movie;
  }
  
}
