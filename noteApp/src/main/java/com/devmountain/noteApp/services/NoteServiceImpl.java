package com.devmountain.noteApp.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmountain.noteApp.dtos.NoteDto;
import com.devmountain.noteApp.entities.Note;
import com.devmountain.noteApp.entities.User;
import com.devmountain.noteApp.repositories.NoteRepository;
import com.devmountain.noteApp.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class NoteServiceImpl implements NoteService {
  
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private NoteRepository noteRepository;

  // find all notes by userId
  @Override
  @Transactional
  public List<NoteDto> getAllNotesByUserId(Long userId) {

    Optional<User> userOptional = userRepository.findById(userId);
    
    if (userOptional.isPresent()) {
      List<Note> noteList = noteRepository.findAllByUserEquals(userOptional.get());
      return noteList.stream().map(note -> new NoteDto(note)).collect(Collectors.toList());
    }
    return Collections.emptyList();

  }


  // add a note
  // using the userId to find the user's notes
  @Override
  @Transactional
  public void addNote(NoteDto noteDto, Long userId) {
    Optional<User> userOptional = userRepository.findById(userId);
    Note note = new Note(noteDto);
    userOptional.ifPresent(note::setUser); // method reference to call setUser on the note object
    noteRepository.saveAndFlush(note);
  }

  // delete a note
  @Override
  @Transactional
  public void deleteNoteById(Long noteId) {
    Optional<Note> noteOptional = noteRepository.findById(noteId);
    noteOptional.ifPresent(note -> noteRepository.delete(note));
  }

  // find a note by id
  @Override
  @Transactional
  public Optional<NoteDto> getNoteById(Long noteId) {
    Optional<Note> noteOptional = noteRepository.findById(noteId);
    if (noteOptional.isPresent()) {
      return Optional.of(new NoteDto(noteOptional.get()));
    }
    return Optional.empty();
  }

  // update note by id 
  @Override
  @Transactional
  public void updateNoteById(NoteDto noteDto) {
    Optional<Note> noteOptional = noteRepository.findById(noteDto.getId());
    noteOptional.ifPresent(note -> {
      note.setBody(noteDto.getBody());
      noteRepository.saveAndFlush(note);
    });
  }
}
