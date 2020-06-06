package com.ap.webNotes.controller;

import com.ap.webNotes.models.Note;
import com.ap.webNotes.repository.NoteRepositiry;
import com.ap.webNotes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class webNotesController {
    @Autowired
    private NoteService noteService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");
        List<Note> listNote = noteService.getAll();
        mav.addObject("listNote", listNote);
        mav.addObject("note", new Note());
        return mav;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView add(@Validated Note note, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        noteService.saveNote(note);
        List<Note> listNote = noteService.getAll();
        mav.addObject("listNote", listNote);
        mav.addObject("note", new Note());
        mav.setViewName("home");
        return mav;
    }

    @RequestMapping(value = "/edit/{noteId}", method = RequestMethod.GET)
    public ModelAndView update(@PathVariable Integer noteId) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("note", noteService.findById(noteId));
        mav.setViewName("edit_note");
        return mav;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView do_update(@Validated Note n, BindingResult bindingResult) {
        noteService.saveNote(n);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/delete/{noteId}", method = RequestMethod.GET)
    public ModelAndView delete_confirm(@PathVariable Integer noteId) {
        ModelAndView mav = new ModelAndView();
        Optional<Note>noteFound = noteService.findById(noteId);
        mav.addObject("note", noteFound.get());
        mav.setViewName("delete_confirm");
        return mav;
    }

    @RequestMapping(value = "/do_delete", method = RequestMethod.POST)
    public ModelAndView do_delete(@Validated Note n, BindingResult bindingResult) {
        noteService.deleteNote(n.getId());
        return new ModelAndView("redirect:/");
    }
}
