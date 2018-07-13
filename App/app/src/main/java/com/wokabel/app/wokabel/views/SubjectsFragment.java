package com.wokabel.app.wokabel.views;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
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
    private ArrayList<String> mImageUrls = new ArrayList<>();
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
        mImageUrls.clear();
        mNames.clear();
        mNames.add(model.getSupergroups().toString());
        //mImageUrls.add("https://cdn.pixabay.com/photo/2013/07/12/13/27/england-147080_960_720.png");
        //mNames.add("English"); //noch mit strings.xml verknüpfen

        //mImageUrls.add("https://breite-apotheke.ch/wp-content/uploads/2016/05/Franz%C3%B6sisch.gif");
        //mNames.add("French"); //noch mit strings.xml verknüpfen
        //mNames = model.getAllSupergroups();
        initRecyclerView();

    }

    private void initRecyclerView() {

        Log.d(TAG, "initRecyclerView: inti recyclerView.");

        //RecyclerViewAdapter adapter = new RecyclerViewAdapter(/*model.getSupergroups(), mImageUrls, */getView().getContext()/*, model.getAllIDs()*/);
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
        Snackbar.make(view, "Hier sollte jetzt ne neue Activity zum Erstellen eines Subjects sein!", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
