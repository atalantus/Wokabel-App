package com.wokabel.app.wokabel.views;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wokabel.app.wokabel.R;
import com.wokabel.app.wokabel.models.Supergroup;
import com.wokabel.app.wokabel.viewModels.SubjectSelectViewModel;

import java.util.ArrayList;
import java.util.List;

public class SubjectsFragment extends Fragment {

    private RecyclerView recyclerView;
    private static final String TAG = "SubjectsFragment";
    private ArrayList<String> mNames = new ArrayList<>();
    private SubjectSelectViewModel model;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_subjects, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = ViewModelProviders.of(this).get(SubjectSelectViewModel.class);
        //mNames = model.getSupergroups();
        Log.d(TAG, "onCreate: started.");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.recycler_view);
        initImageBitmaps();
    }

    public static SubjectsFragment newInstance() {
        return new SubjectsFragment();
    }


    //Initialisierung der Bilder und Namen
    public void initImageBitmaps() {

        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");
        mNames.clear();
        mNames.add(model.getSupergroups().toString());
        initRecyclerView();
    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: inti recyclerView.");
        final SubjectSelectAdapter adapter = new SubjectSelectAdapter(this.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        model.getSupergroups().observe(this, new Observer<List<Supergroup>>() {
            @Override
            public void onChanged(@Nullable final List<Supergroup> supergroups) {
                adapter.setmSupergroups((ArrayList<Supergroup>) supergroups);
                Log.d(TAG, "LiveData changed");
            }
        });
    }

    public void createSubject(View view) {
        Intent intent = new Intent(view.getContext(),EditSubject.class);
        view.getContext().startActivity(intent);
        //Snackbar.make(view, "Hier sollte jetzt ne neue Activity zum Erstellen eines Subjects sein!", Snackbar.LENGTH_LONG)
          //      .setAction("Action", null).show();
    }
}
