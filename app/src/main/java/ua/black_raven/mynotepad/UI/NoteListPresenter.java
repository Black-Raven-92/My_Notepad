package ua.black_raven.mynotepad.UI;

import java.util.List;

import ua.black_raven.mynotepad.logic.Note;
import ua.black_raven.mynotepad.logic.NoteRepository;

public class NoteListPresenter {
    private NoteListView view;
    private NoteRepository repository;

    public NoteListPresenter(NoteListView view, NoteRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    public void refresh(){
        List<Note> result=repository.getAllNotes();
        view.showNotes(result);
    }
}
