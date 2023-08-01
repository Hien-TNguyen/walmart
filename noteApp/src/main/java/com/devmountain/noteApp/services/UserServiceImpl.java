package com.devmountain.noteApp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.devmountain.noteApp.dtos.UserDto;
import com.devmountain.noteApp.entities.User;
import com.devmountain.noteApp.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {
  
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private PasswordEncoder passwordEncoder;

  // User register
  @Override
  @Transactional // saving to db
  public List<String> addUser(UserDto userDto) {

    List<String> response = new ArrayList<>();
    User user = new User(userDto);
    userRepository.saveAndFlush(user);
    response.add("http://localhost:8080/login.html");
    return response;
  }

  // User logging 
  @Override
  public List<String> userLogin(UserDto userDto) {
    List<String> response = new ArrayList<>();
    Optional<User> userOptional = userRepository.findByUsername(userDto.getUsername());

    // check if userOptional is present
    if (userOptional.isPresent()) {
      // if the password is matched
      if (passwordEncoder.matches(userDto.getPassword(), userOptional.get().getPassword())) {
        response.add("http://localhost:8080/home.html");
        response.add(String.valueOf(userOptional.get().getId()));
      } else {
        response.add("Username or password incorrect");
      }
    } else {
      response.add("Username or password incorrect");
    }
    return response;
  }

}
