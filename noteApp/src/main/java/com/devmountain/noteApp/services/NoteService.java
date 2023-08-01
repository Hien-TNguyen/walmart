package com.devmountain.noteApp.services;

import java.util.List;
import java.util.Optional;

import com.devmountain.noteApp.dtos.NoteDto;
import com.devmountain.noteApp.dtos.UserDto;

import jakarta.transaction.Transactional;

public interface NoteService {

  // find all notes by username
  List<NoteDto> getAllNotesByUserId(Long userId);

  // add a note
  // using the userId to find the user's notes
  void addNote(NoteDto noteDto, Long userId);

  // delete a note
  void deleteNoteById(Long noteId);

  // find a note by id
  Optional<NoteDto> getNoteById(Long noteId);

  // update note by id 
  void updateNoteById(NoteDto noteDto);

}