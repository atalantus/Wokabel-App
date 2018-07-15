package com.wokabel.app.wokabel.views;

import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.app.Activity;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.wokabel.app.wokabel.R;
import com.wokabel.app.wokabel.models.Subgroup;
import com.wokabel.app.wokabel.services.room.DatabaseAdapter;
import com.wokabel.app.wokabel.viewModels.UnitSelectViewModel;

import java.util.List;

import java.util.ArrayList;

public class UnitSelect extends AppCompatActivity {

    private static final String TAG = "UnitSelect";

    private RecyclerView recyclerView;

    private ArrayList<String> mNames = new ArrayList<>();

    UnitSelectViewModel model;
    LiveData<List<Subgroup>> subgroups;

    public UnitSelect(){
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_select);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);


        model = ViewModelProviders.of(this).get(UnitSelectViewModel.class);
        setTitle(getIntent().getStringExtra(SubjectSelectAdapter.EXTRA_MESSAGE2));
        //start();
        //setTitle(model.getSelectedSupergroup());
        new LoadData(new DatabaseAdapter(getApplication()), this).execute();
    }
    public void start(){

        setTitle(model.getSelectedSupergroup());
        model.setSelectedSupergroup(getIntent().getStringExtra(SubjectSelectAdapter.EXTRA_MESSAGE));
    }

    public void createUnit(View view) {
        // TODO
        Snackbar.make(view, "Hier sollte jetzt ne neue Activity zum Erstellen einer Unit sein!", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    private static class LoadData extends AsyncTask<Void, Void, Void> {

        private final DatabaseAdapter mDb;
        private final Activity mActivity;

        LoadData(DatabaseAdapter db, Activity activity) {
            mDb = db;
            mActivity = activity;

        }

        @Override
        protected Void doInBackground(final Void... params) {
            //set selected Supergroup and load Data
            UnitSelectViewModel model = ViewModelProviders.of((FragmentActivity) mActivity).get(UnitSelectViewModel.class);
            model.setSelectedSupergroup(mActivity.getIntent().getStringExtra(SubjectSelectAdapter.EXTRA_MESSAGE));
            Log.d("UnitSelect","set selected Supergroup");
            return null;
        }
    }

    private void initBitmap(){

        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        //TODO: mNames.add(model.getSupergroups().getName());
        mNames.add("Unit1"); //noch mit strings.xml verknüpfen
        mNames.add("Unit2"); //noch mit strings.xml verknüpfen

        initRecyclerView();

    }

    private void initRecyclerView() {

        Log.d(TAG, "initRecyclerView: inti recyclerView.");

        UnitSelectAdapter adapter = new UnitSelectAdapter(mNames, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void createSubject(View view) {
        Snackbar.make(view, "Hier sollte jetzt ne neue Activity zum Erstellen eines Subjects sein!", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

}
