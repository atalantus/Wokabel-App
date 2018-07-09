package com.wokabel.app.wokabel.views;

import android.os.Bundle;
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

import java.util.ArrayList;


public class SubjectsFragment extends Fragment {

    private RecyclerView recyclerView;

    private static final String TAG = "SubjectsFragment";

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_subjects, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate: started.");
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        recyclerView = getView().findViewById(R.id.recycler_view);
        initImageBitmaps();
    }

    public static SubjectsFragment newInstance() {
        SubjectsFragment fragment = new SubjectsFragment();
        return fragment;
    }


    //Initialisierung der Bilder und Namen
    public void initImageBitmaps() {

        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");
        mImageUrls.clear();
        mNames.clear();
        //TODO: mNames.add(model.getSupergroups().getName());
        mImageUrls.add("https://cdn.pixabay.com/photo/2013/07/12/13/27/england-147080_960_720.png");
        mNames.add("English"); //noch mit strings.xml verknüpfen

        mImageUrls.add("https://breite-apotheke.ch/wp-content/uploads/2016/05/Franz%C3%B6sisch.gif");
        mNames.add("French"); //noch mit strings.xml verknüpfen

        initRecyclerView();

    }

    private void initRecyclerView() {

        Log.d(TAG, "initRecyclerView: inti recyclerView.");

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mNames, mImageUrls, getView().getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getView().getContext()));
    }

    public void createSubject(View view) {
        Snackbar.make(view, "Hier sollte jetzt ne neue Activity zum Erstellen eines Subjects sein!", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
