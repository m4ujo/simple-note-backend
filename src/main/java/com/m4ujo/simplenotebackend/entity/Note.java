package com.m4ujo.simplenotebackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "note")
public class Note {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false)
  private UUID id;
  private String title;
  @Column(columnDefinition = "TEXT")
  private String description;
  @CreationTimestamp
  @Column(name = "created_at")
  private Date createdAt;
  @UpdateTimestamp
  @Column(name = "updated_at")
  private Date updatedAt;
  private String colorName;
}
