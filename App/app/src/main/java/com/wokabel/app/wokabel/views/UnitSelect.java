package com.wokabel.app.wokabel.views;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.wokabel.app.wokabel.R;
import com.wokabel.app.wokabel.models.Subgroup;
import com.wokabel.app.wokabel.viewModels.UnitSelectViewModel;

import java.util.ArrayList;
import java.util.List;

public class UnitSelect extends AppCompatActivity {

    private static final String TAG = "UnitSelect";

    UnitSelectViewModel model;
    RecyclerView recyclerView;
    UnitSelectAdapter adapter;

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

        recyclerView = findViewById(R.id.recycler_view);
        adapter = new UnitSelectAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        model = ViewModelProviders.of(this).get(UnitSelectViewModel.class);
        setTitle(getIntent().getStringExtra(SubjectSelectAdapter.SELECTED_SUPERGROUP_NAME) + " " + getString(R.string.units));
        new LoadData(this).execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.unit_select_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_random:
                // TODO: Select random Unit
                return true;

            case R.id.action_export_subject:
                // TODO: Export whole subject with data as xml file
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d("UnitSelect",String.valueOf(model.getSubgroups()==null));
    }

    public void createUnit(View view) {
        // TODO
        Snackbar.make(view, "Hier sollte jetzt ne neue Activity zum Erstellen einer Unit sein!", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    private static class LoadData extends AsyncTask<Void, Void, Void> {

        private final UnitSelect mActivity;

        LoadData(UnitSelect activity) {
            mActivity = activity;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            //set selected Supergroup and load Data
            UnitSelectViewModel model = ViewModelProviders.of((FragmentActivity) mActivity).get(UnitSelectViewModel.class);
            model.setSelectedSupergroup(mActivity.getIntent().getStringExtra(SubjectSelectAdapter.SELECTED_SUPERGROUP_ID));

            Log.d("UnitSelect","set selected Supergroup");
            model.getSubgroups().observe(mActivity, new Observer<List<Subgroup>>() {
                @Override
                public void onChanged(@Nullable List<Subgroup> subgroups) {
                    mActivity.adapter.setSubgroups((ArrayList<Subgroup>) subgroups);
                }
            });
            return null;
        }
    }

    public void createSubject(View view) {
        Snackbar.make(view, "Hier sollte jetzt ne neue Activity zum Erstellen eines Subjects sein!", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

}
