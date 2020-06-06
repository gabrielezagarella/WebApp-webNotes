package com.ap.webNotes.service;

import com.ap.webNotes.models.Note;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface NoteService {
    public  void saveNote(Note n);
    public List<Note> getAll();
    public Optional<Note> findById(Integer noteId);
}
