package com.wokabel.app.wokabel.views;

import android.app.Activity;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.wokabel.app.wokabel.R;
import com.wokabel.app.wokabel.models.Subgroup;
import com.wokabel.app.wokabel.viewModels.UnitSelectViewModel;

import java.util.List;

public class UnitSelect extends AppCompatActivity {

    private static final String TAG = "UnitSelect";

    UnitSelectViewModel model;
    LiveData<List<Subgroup>> subgroups;

    public UnitSelect(){
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_select);
        model = ViewModelProviders.of(this).get(UnitSelectViewModel.class);
        setTitle(getIntent().getStringExtra(SubjectSelectAdapter.SELECTED_SUPERGROUP_NAME) + " " + getString(R.string.units));
        new LoadData(this).execute();
    }

    private static class LoadData extends AsyncTask<Void, Void, Void> {

        private final Activity mActivity;

        LoadData(Activity activity) {
            mActivity = activity;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            //set selected Supergroup and load Data
            UnitSelectViewModel model = ViewModelProviders.of((FragmentActivity) mActivity).get(UnitSelectViewModel.class);
            model.setSelectedSupergroup(mActivity.getIntent().getStringExtra(SubjectSelectAdapter.SELECTED_SUPERGROUP_ID));
            Log.d("UnitSelect","set selected Supergroup");
            return null;
        }
    }

    public void createSubject(View view) {
        Snackbar.make(view, "Hier sollte jetzt ne neue Activity zum Erstellen eines Subjects sein!", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

}
