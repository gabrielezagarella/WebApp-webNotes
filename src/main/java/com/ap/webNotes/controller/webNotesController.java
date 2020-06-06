package com.ap.webNotes.controller;

import com.ap.webNotes.models.Note;
import com.ap.webNotes.repository.NoteRepositiry;
import com.ap.webNotes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class webNotesController {
    @Autowired
    private NoteService noteService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home () {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");
        List<Note>listNote = noteService.getAll();
        mav.addObject("listNote", listNote);
        return mav;
    }
}
