package com.yusufborucu.springrestapi.controller;

import com.yusufborucu.springrestapi.model.Note;
import com.yusufborucu.springrestapi.service.NoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/notes")
    public Note addNote(@RequestBody Note note) {
        return noteService.addNote(note);
    }

    @GetMapping("/notes")
    public List<Note> getNotes() {
        return noteService.getNotes();
    }

    @GetMapping("/notes/{id}")
    public Note getNote(@PathVariable Long id) {
        return noteService.getNote(id);
    }

    @PutMapping("/notes/{id}")
    public Note editNote(@PathVariable Long id, @RequestBody Note note) {
        return noteService.editNote(id, note);
    }

    @DeleteMapping("/notes/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
    }

}
