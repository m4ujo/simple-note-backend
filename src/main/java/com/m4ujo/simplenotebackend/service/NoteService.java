package com.m4ujo.simplenotebackend.service;

import com.m4ujo.simplenotebackend.entity.Note;
import com.m4ujo.simplenotebackend.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NoteService {
  private final NoteRepository noteRepository;

  @Autowired
  public NoteService (NoteRepository noteRepository) {
    this.noteRepository = noteRepository;
  }

  public List<Note> getNotes() {
    return noteRepository.findAll();
  }

  public Note getNoteById(UUID id) {
    return noteRepository.findById(id).orElseThrow(() -> new IllegalStateException("Note not founded"));
  }

  public void createNote (Note note) {
    noteRepository.save(note);
  }

  public void updateNote (UUID id, Note updatedNote) {
    try {
      Note note = getNoteById(id);
      note.setTitle(updatedNote.getTitle());
      note.setDescription(updatedNote.getDescription());
      note.setColorName(updatedNote.getColorName());
      noteRepository.save(note);
    } catch (Exception ex) {
      throw new IllegalStateException("Note not founded");
    }
  }

  public void deleteNote (UUID id) {
    try {
      Note note = getNoteById(id);
      noteRepository.delete(note);
    } catch (Exception ex) {
      throw new IllegalStateException("Note not founded");
    }
  }
}
