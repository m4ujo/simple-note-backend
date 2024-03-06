package com.m4ujo.simplenotebackend.repository;

import com.m4ujo.simplenotebackend.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface NoteRepository extends JpaRepository<Note, UUID> {
  @Query("SELECT note FROM Note note WHERE note.colorName = ?1")
  List<Note> findByColor(String color_name);
}
