package com.javaunit3.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MovieController {

  @Autowired
  BestMovieService bms;
  
  // create a mapping for "/" 
  @RequestMapping("/")
  public String getIndexPage() {
    return "index";
  }

  @RequestMapping("/bestMovie")
  public String getBestMoviePage(Model model) {
    model.addAttribute("BestMovie", bms.getBestMovie().getTitle());
    return "bestMovie.html";
  }

  @RequestMapping("/voteForBestMovieForm")
  public String voteForBestMovieFormPage() {
    return "voteForBestMovie";
  }

  @RequestMapping("/voteForBestMovie")
  public String voteForBestMovie(HttpServletRequest request, Model model) {
    
    String movieTitle = request.getParameter("movieTitle");
    model.addAttribute("BestMovieVote", movieTitle);
    return "voteForBestMovie";
  }

}
