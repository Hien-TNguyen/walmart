package com.devmountain.noteApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devmountain.noteApp.dtos.UserDto;
import com.devmountain.noteApp.services.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
  // Autowire in the dependencies -> the userService and passwordEncoder
  @Autowired
  private UserService userService;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @PostMapping("/register")
  public List<String> addUser(@RequestBody UserDto userDto) {
    // hash the incoming password
    String passHash = passwordEncoder.encode(userDto.getPassword());
    // invoke setPassword() on the userDto
    userDto.setPassword(passHash);
    // return the addUser() method on userService dependency
    return userService.addUser(userDto);
  }

  // user login 
  @PostMapping("/login")
  public List<String> userLogin(@RequestBody UserDto userDto) {
    return userService.userLogin(userDto);
  }
  
}
