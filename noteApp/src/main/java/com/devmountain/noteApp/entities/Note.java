package com.devmountain.noteApp.entities;

import com.devmountain.noteApp.dtos.NoteDto;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="notes")
@Data 
@AllArgsConstructor
@NoArgsConstructor
public class Note {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="note_id")
  private Long id;

  @Column(columnDefinition = "text")
  private String body;

  @ManyToOne
  @JsonBackReference // prevents infinite recursion when deliver the resourse up as JSON
  private User user;

  
  public Note(NoteDto noteDto) {
    if (noteDto.getBody() != null) {
      this.body = noteDto.getBody();
    }
  }
  
}
