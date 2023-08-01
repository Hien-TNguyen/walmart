package com.devmountain.noteApp.entities;

import java.util.HashSet;
import java.util.Set;

import com.devmountain.noteApp.dtos.UserDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

  // define fields
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="user_id")
  private Long id;

  @Column(name="username")
  private String username;

  @Column(name="password")
  private String password;

  @OneToMany(mappedBy="user", fetch=FetchType.LAZY, cascade={CascadeType.MERGE, CascadeType.PERSIST})
  @JsonManagedReference
  private Set<Note> noteSet = new HashSet<>();

  
  public User(UserDto userDto) {
    if (userDto.getUsername() != null) {
      this.username = userDto.getUsername();
    }
    if (userDto.getPassword() != null) {
      this.password = userDto.getPassword();
    }
  }

  // define no args constructor/ all args constructor -> Using Lombok
  // define getters/setters -> Lombok
  // define toString 

}
