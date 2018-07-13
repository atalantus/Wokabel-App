package com.wokabel.app.wokabel.views;

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

public class UnitSelect extends AppCompatActivity {

    UnitSelectViewModel model;
    LiveData<List<Subgroup>> subgroups;

    public UnitSelect(){
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_select);


        model = ViewModelProviders.of(this).get(UnitSelectViewModel.class);
        setTitle(getIntent().getStringExtra(RecyclerViewAdapter.EXTRA_MESSAGE2));
        //start();
        //setTitle(model.getSelectedSupergroup());
        new LoadData(new DatabaseAdapter(getApplication()), this).execute();
    }
    public void start(){

        setTitle(model.getSelectedSupergroup());
        model.setSelectedSupergroup(getIntent().getStringExtra(RecyclerViewAdapter.EXTRA_MESSAGE));
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
            model.setSelectedSupergroup(mActivity.getIntent().getStringExtra(RecyclerViewAdapter.EXTRA_MESSAGE));
            Log.d("UnitSelect","set selected Supergroup");
            return null;
        }
    }
}
