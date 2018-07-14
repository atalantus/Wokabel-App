package com.wokabel.app.wokabel.views;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.wokabel.app.wokabel.R;
import com.wokabel.app.wokabel.viewModels.EditSubjectViewModel;

import static com.wokabel.app.wokabel.views.SubjectSelectAdapter.SELECTED_SUPERGROUP_EDIT;

public class EditSubject extends AppCompatActivity {

    ViewModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_subject);
        model = ViewModelProviders.of(this).get(EditSubjectViewModel.class);
        setTitle(getIntent().getStringExtra(SELECTED_SUPERGROUP_EDIT));
        Log.d("EditSubject", getIntent().getStringExtra(SELECTED_SUPERGROUP_EDIT));
        new LoadData(this).execute();
    }

    private static class LoadData extends AsyncTask<Void, Void, Void> {

        private final AppCompatActivity mActivity;

        LoadData(AppCompatActivity activity) {
            mActivity = activity;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            //set selected Supergroup and load Data
            EditSubjectViewModel model = ViewModelProviders.of(mActivity).get(EditSubjectViewModel.class);
            model.setSelectedSuptergroup(mActivity.getIntent().getStringExtra(SubjectSelectAdapter.SELECTED_SUPERGROUP_ID));
            //Log.d("EditSubject", model.getSelectedSuptergroup().getName());
            return null;
        }
    }

}
