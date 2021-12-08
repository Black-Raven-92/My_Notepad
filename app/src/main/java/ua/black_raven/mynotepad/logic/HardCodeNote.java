package ua.black_raven.mynotepad.logic;

import java.util.ArrayList;
import java.util.List;

public class HardCodeNote implements NoteRepository{


    @Override
    public List<Note> getAllNotes() {
        ArrayList<Note> notes = new ArrayList<>();
        notes.add(new Note(1,"Позавтракать","08.12.2021","Утром позавтракать",false,2));
        notes.add(new Note(1,"Ужин","08.12.2021","Вечером поужинать",false,2));
        notes.add(new Note(1,"Купить хлеб","08.12.2021","Купит хлеб обязательно",false,1));



        return notes;
    }

    @Override
    public void addNote(Note note) {

    }

    @Override
    public void removeNote(Note note) {

    }
}
