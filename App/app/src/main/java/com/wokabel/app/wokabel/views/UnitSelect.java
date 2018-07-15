package com.wokabel.app.wokabel.views;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

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
        recyclerView = findViewById(R.id.recycler_view);
        adapter = new UnitSelectAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        model = ViewModelProviders.of(this).get(UnitSelectViewModel.class);
        setTitle(getIntent().getStringExtra(SubjectSelectAdapter.SELECTED_SUPERGROUP_NAME) + " " + getString(R.string.units));
        TextView textView = findViewById(R.id.textView);
        textView.setText(getIntent().getStringExtra(SubjectSelectAdapter.SELECTED_SUPERGROUP_NAME));
        new LoadData(this).execute();
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d("UnitSelect",String.valueOf(model.getSubgroups()==null));
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
