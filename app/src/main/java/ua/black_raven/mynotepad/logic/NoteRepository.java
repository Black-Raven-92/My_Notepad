package ua.black_raven.mynotepad.logic;

import java.util.List;

public interface NoteRepository {
    List<Note> getAllNotes();

    void addNote(Note note);

    void removeNote(Note note);

}
