package com.m4ujo.simplenotebackend.controller;

import com.m4ujo.simplenotebackend.entity.Note;
import com.m4ujo.simplenotebackend.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/notes")
public class NoteController {
  private final NoteService noteService;

  @Autowired
  public NoteController(NoteService noteService) {
    this.noteService = noteService;
  }

  @GetMapping
  public List<Note> getNotes() {
    return noteService.getNotes();
  }

  @GetMapping(path = "/{id}")
  public Note getNoteById(@PathVariable UUID id) {
    return noteService.getNoteById(id);
  }

  @PostMapping
  public void createNote(@RequestBody Note note) {
    noteService.createNote(note);
  }

  @PutMapping(path = "/{id}")
  public void updateNote(
    @PathVariable UUID id,
    @RequestBody Note note) {
    noteService.updateNote(id, note);
  }

  @DeleteMapping(path = "/{id}")
  public void deleteNote(
    @PathVariable UUID id) {
    noteService.deleteNote(id);
  }
}
