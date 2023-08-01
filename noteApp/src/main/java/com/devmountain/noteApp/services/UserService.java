package com.devmountain.noteApp.services;

import java.util.List;

import com.devmountain.noteApp.dtos.UserDto;

import jakarta.transaction.Transactional;

public interface UserService {

  // User register
  @Transactional
  List<String> addUser(UserDto userDto);

  // User logging 
  List<String> userLogin(UserDto userDto);

}