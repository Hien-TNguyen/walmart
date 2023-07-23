package com.javaunit3.springmvc;

import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaunit3.springmvc.model.MovieEntity;
import com.javaunit3.springmvc.model.VoteEntity;


@Controller
public class MovieController {

  @Autowired
  BestMovieService bms;

  @Autowired
  private SessionFactory sessionFactory;

  
  // create a mapping for "/" 
  @RequestMapping("/")
  public String getIndexPage() {
    return "index";
  }

  @RequestMapping("/bestMovie")
  public String getBestMoviePage(Model model) {

    // create a new session
    Session session = sessionFactory.getCurrentSession();
    session.beginTransaction();

    List<MovieEntity> movieEntityList = session.createQuery("from MovieEntity").list();
    movieEntityList.sort(Comparator.comparing(movieEntity -> movieEntity.getVotes().size()));
    

    model.addAttribute("BestMovie", bms.getBestMovie().getTitle());
    return "bestMovie.html";
  }

  @RequestMapping("/voteForBestMovieForm")
  public String voteForBestMovieFormPage(Model model) {
    
    Session session = sessionFactory.getCurrentSession();
    session.beginTransaction();

    List<MovieEntity> movieEntityList = session.createQuery("from MoviewEntity").list();
    
    session.getTransaction().commit();

    model.addAttribute("movies", movieEntityList);
    
    return "voteForBestMovie";
  }

  @RequestMapping("/voteForBestMovie")
  public String voteForBestMovie(HttpServletRequest request, Model model) {
    
    // get voter name and movie id from the request
    String voterName = request.getParameter("voterName");
    String movieId = request.getParameter("movieId");

    // create a session
    Session session = sessionFactory.getCurrentSession();

    // begin transaction
    session.beginTransaction();
    // get movie from database using movie id
    MovieEntity movieEntity = (MovieEntity) session.get(MovieEntity.class, Integer.parseInt((movieId)));
    // create a new vote object
    VoteEntity newVote = new VoteEntity();
    // set voter name 
    newVote.setVoterName(voterName);
    // add vote to the movie 
    movieEntity.addVote(newVote);

    // update session with new data
    session.update(movieEntity);
    // save the data
    session.getTransaction().commit();

    return "voteForBestMovie";
  }

  @RequestMapping("/addMovieForm")
  public String addMovieForm() {
    return "addMovie";
  }

  @RequestMapping("/addMovie") 
  public String addMovie(HttpServletRequest request) {
      
    String title = request.getParameter("movieTitle");
    String maturityRating = request.getParameter("maturityRating");
    String genre = request.getParameter("genre");

    MovieEntity movieEntity = new MovieEntity();
    movieEntity.setTitle(title);
    movieEntity.setMaturityRating(maturityRating);
    movieEntity.setGenre(genre);

    Session session = sessionFactory.getCurrentSession();

    session.beginTransaction();

    session.save(movieEntity);
    session.getTransaction().commit();

    return "addMovie";
  }

}
