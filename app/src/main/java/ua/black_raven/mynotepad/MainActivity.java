package ua.black_raven.mynotepad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentResultListener;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Button;

import ua.black_raven.mynotepad.UI.NoteDetailsFragment;
import ua.black_raven.mynotepad.UI.NoteListFragment;
import ua.black_raven.mynotepad.logic.Note;

public class MainActivity extends AppCompatActivity {
    public static final String ARG_NOTE = "ARG_NOTE";
    private Note selectedNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.notes_container, new NoteListFragment())
                .addToBackStack("main")
                .commit();
        if (savedInstanceState != null && savedInstanceState.containsKey(ARG_NOTE)) {
            selectedNote = savedInstanceState.getParcelable(ARG_NOTE);
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                showDetails();
            }

        }
        getSupportFragmentManager()
                .setFragmentResultListener(NoteListFragment.RESULT_KEY, this, new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                        selectedNote = result.getParcelable(NoteListFragment.ARG_NOTE);
                        if(getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE){
                            showDetails();
                        }else {
                            getSupportFragmentManager()
                                    .beginTransaction()
                                    .replace(R.id.notes_container,new NoteDetailsFragment().newInstance(selectedNote))
                                    .addToBackStack("main")
                                    .commit();
                        }
                    }
                });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (selectedNote != null) {
            outState.putParcelable(ARG_NOTE, selectedNote);
        }
    }

    private void showDetails() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(NoteDetailsFragment.ARG_NOTE, selectedNote);
        getSupportFragmentManager()
                .setFragmentResult(NoteDetailsFragment.KEY_RESULT, bundle);
    }

}