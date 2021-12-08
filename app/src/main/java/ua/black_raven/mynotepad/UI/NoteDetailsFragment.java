package ua.black_raven.mynotepad.UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import ua.black_raven.mynotepad.R;
import ua.black_raven.mynotepad.logic.Note;

public class NoteDetailsFragment extends Fragment {
    public static final String ARG_NOTE = "ARG_NOTE";
    public static final String KEY_RESULT = "NoteDetailsFragment_KEY_RESULT";
    private TextView noteTitle;
    private TextView noteText;
    private TextView noteDate;

    public NoteDetailsFragment() {
        super(R.layout.fragment_details_note);
    }

    public static NoteDetailsFragment newInstance(Note note) {
        NoteDetailsFragment fragment = new NoteDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_NOTE, note);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        noteTitle = view.findViewById(R.id.title_detail);
        noteText = view.findViewById(R.id.descript_detail);
        noteDate = view.findViewById(R.id.date_detail);
        if (getArguments() != null && getArguments().containsKey(ARG_NOTE)) {
            displayDetails(getArguments().getParcelable(ARG_NOTE));
        }
        getParentFragmentManager()
                .setFragmentResultListener(KEY_RESULT, getViewLifecycleOwner(), new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                        Note note = result.getParcelable(NoteListFragment.ARG_NOTE);
                    }
                });
    }

    private void displayDetails(Note note) {
        noteTitle.setText(note.getTitle());
        noteText.setText(note.getText());
        noteDate.setText(note.getDate());
    }
}
