package com.wokabel.app.wokabel.views;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.wokabel.app.wokabel.R;
import com.wokabel.app.wokabel.viewModels.EditSubjectViewModel;

import static com.wokabel.app.wokabel.views.SubjectSelectAdapter.SELECTED_SUPERGROUP_EDIT;

public class EditSubject extends AppCompatActivity {

    ViewModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_subject);
        TextView supergroupName = findViewById(R.id.edit_name);
        supergroupName.setText(getIntent().getStringExtra(SELECTED_SUPERGROUP_EDIT));
        model = ViewModelProviders.of(this).get(EditSubjectViewModel.class);
        setTitle(getIntent().getStringExtra(SELECTED_SUPERGROUP_EDIT));
        Log.d("EditSubject", getIntent().getStringExtra(SELECTED_SUPERGROUP_EDIT));
        new ProvideModel(this).execute();

    }

    private static class ProvideModel extends AsyncTask<Void, Void, Void> {

        private final AppCompatActivity mActivity;

        ProvideModel(AppCompatActivity activity) {
            super();
            mActivity = activity;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            //set selected Supergroup and load Data
            EditSubjectViewModel model1 = ViewModelProviders.of(mActivity).get(EditSubjectViewModel.class);
            //EditSubjectViewModel model = ViewModelProviders.of(mActivity).get(EditSubjectViewModel.class);
            model1.setSelectedSupergroup(mActivity.getIntent().getStringExtra(SubjectSelectAdapter.SELECTED_SUPERGROUP_ID));
            //model.setSelectedSupergroup(mActivity.getIntent().getStringExtra(SubjectSelectAdapter.SELECTED_SUPERGROUP_ID));

            //Log.d("EditSubject", model.getSelectedSupergroup().getName());
            return null;
        }
    }

}
