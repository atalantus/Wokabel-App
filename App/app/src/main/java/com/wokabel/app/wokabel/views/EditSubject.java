package com.wokabel.app.wokabel.views;

import android.arch.lifecycle.ViewModelProviders;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.wokabel.app.wokabel.R;
import com.wokabel.app.wokabel.viewModels.EditSubjectViewModel;

import static com.wokabel.app.wokabel.views.SubjectSelectAdapter.SELECTED_SUPERGROUP_EDIT;
import static com.wokabel.app.wokabel.views.SubjectSelectAdapter.SELECTED_SUPERGROUP_NAME;

public class EditSubject extends AppCompatActivity {

    private EditSubjectViewModel model;
    private boolean edit;
    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_subject);
        name = findViewById(R.id.edit_name);
        model = ViewModelProviders.of(this).get(EditSubjectViewModel.class);
        String intent = getIntent().getStringExtra(SELECTED_SUPERGROUP_EDIT);
        if(intent!= null){
        if (intent.equals("true")) {
            edit = true;
        }}
        if(edit){
            name.setText(getIntent().getStringExtra(SELECTED_SUPERGROUP_NAME));
            setTitle(getString(R.string.edit_of) + " " + getIntent().getStringExtra(SELECTED_SUPERGROUP_NAME));
            new ProvideModelEdit(this).execute();
        } else {
            name.setText(getString(R.string.new_subject));
            setTitle(getString(R.string.new_subject));
            Button deletebtn = findViewById(R.id.delete_btn);
            deletebtn.setVisibility(View.GONE);
            //new ProvideModelNoEdit(this).execute();
        }
    }

    public void Apply(View view) {
        //model.setSupergroupName(name.getText().toString());
        this.finish();
    }

    private static class ProvideModelEdit extends AsyncTask<Void, Void, Void> {

        private final AppCompatActivity mActivity;

        ProvideModelEdit(AppCompatActivity activity) {
            super();
            mActivity = activity;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            //set selected Supergroup
            EditSubjectViewModel model = ViewModelProviders.of(mActivity).get(EditSubjectViewModel.class);
            model.setSelectedSupergroup(mActivity.getIntent().getStringExtra(SubjectSelectAdapter.SELECTED_SUPERGROUP_ID));
            Log.d("ES","setSupergroup");
            return null;
        }
    }
    private static class ProvideModelNoEdit extends AsyncTask<Void, Void, Void> {

        private final AppCompatActivity mActivity;

        ProvideModelNoEdit(AppCompatActivity activity) {
            super();
            mActivity = activity;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            //set selected Supergroup
            EditSubjectViewModel model = ViewModelProviders.of(mActivity).get(EditSubjectViewModel.class);
            model.setSelectedSupergroup();
            return null;
        }
    }

}
