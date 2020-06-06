package com.ap.webNotes.service;

import com.ap.webNotes.models.Note;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface NoteService {
    public  void saveNote(Note n);
    public List<Note> getAll();
}
