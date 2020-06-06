package com.ap.webNotes.service;

import com.ap.webNotes.models.Note;
import com.ap.webNotes.repository.NoteRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("noteService")
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepositiry noteRepositiry;

    @Override
    public void saveNote(Note n) {
    noteRepositiry.save(n);
    }

    @Override
    public List<Note> getAll() {
        return noteRepositiry.findAll();
    }

    @Override
    public Optional<Note> findById(Integer noteId) {
        return noteRepositiry.findById(noteId);
    }

    @Override
    public void deleteNote(Integer id) {
        noteRepositiry.deleteById(id);
    }
}
