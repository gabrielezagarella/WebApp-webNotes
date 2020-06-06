package com.ap.webNotes.repository;

import com.ap.webNotes.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("noteRepository")
public interface NoteRepositiry extends JpaRepository<Note, Integer> {
}
