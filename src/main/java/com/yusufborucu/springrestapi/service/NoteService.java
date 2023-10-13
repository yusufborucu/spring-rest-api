package com.yusufborucu.springrestapi.service;

import com.yusufborucu.springrestapi.model.Note;
import com.yusufborucu.springrestapi.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note addNote(Note note) {
        return noteRepository.save(note);
    }

    public List<Note> getNotes() {
        return noteRepository.findAll();
    }

    public Note getNote(Long id) {
        Optional<Note> note = noteRepository.findById(id);
        if (note.isPresent()) {
            return note.get();
        }
        throw new RuntimeException("Note is not found");
    }

    public Note editNote(Long id, Note newNote) {
        Note existNote = getNote(id);
        existNote.setTitle(newNote.getTitle());
        existNote.setDescription(newNote.getDescription());
        return noteRepository.save(existNote);
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

}
