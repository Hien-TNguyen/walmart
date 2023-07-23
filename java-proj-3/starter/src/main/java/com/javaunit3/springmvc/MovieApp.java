package com.javaunit3.springmvc;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan
public class MovieApp {
  public static void main(String[] args) {
    // create application context 
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MovieApp.class);
    
    // get the best movie using default bean id
    BestMovieService bestMovieService = applicationContext.getBean("bestMovieService", BestMovieService.class);

    // using the best movie service to get the best movie
    Movie bestMovie = bestMovieService.getBestMovie();

    // print out the title, maturity rating, genre of the best movie
    System.out.println("Title: " + bestMovie.getTitle());
    System.out.println("Maturity Rating: " + bestMovie.getMaturityRating());
    System.out.println("Genre: " + bestMovie.getGenre());
  }
}
