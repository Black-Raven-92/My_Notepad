package ua.black_raven.mynotepad.UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

import ua.black_raven.mynotepad.R;
import ua.black_raven.mynotepad.logic.HardCodeNote;
import ua.black_raven.mynotepad.logic.Note;

public class NoteListFragment extends Fragment implements NoteListView {
    public static final String ARG_NOTE = "ARG_NOTE";
    public static final String RESULT_KEY = "NotesListFragment_RESULT";
    private LinearLayout notesContainer;
    private NoteListPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new NoteListPresenter(this, new HardCodeNote());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note_list,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        notesContainer= view.findViewById(R.id.notes_container_list);
        presenter.refresh();
    }

    @Override
    public void showNotes(List<Note> notes) {
        for (Note note:notes){
            View itemView=LayoutInflater.from(requireContext()).inflate(R.layout.item_note,notesContainer,false);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle data = new Bundle();
                    data.putParcelable(ARG_NOTE,note);
                    getParentFragmentManager()
                            .setFragmentResult(RESULT_KEY,data);
                    Toast.makeText(getActivity(),note.getTitle(),Toast.LENGTH_SHORT).show();
                }
            });
            TextView noteTitle = itemView.findViewById(R.id.title);
            TextView noteDate = itemView.findViewById(R.id.text_date);
            noteTitle.setText(note.getTitle());
            noteDate.setText(note.getDate());
            notesContainer.addView(itemView);
        }

    }
}
