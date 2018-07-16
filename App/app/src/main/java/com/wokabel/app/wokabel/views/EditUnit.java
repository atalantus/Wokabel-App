package com.wokabel.app.wokabel.views;

import android.arch.lifecycle.ViewModelProviders;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.wokabel.app.wokabel.R;
import com.wokabel.app.wokabel.viewModels.EditUnitViewModel;

import static com.wokabel.app.wokabel.views.UnitSelectAdapter.SELECTED_SUBGROUP_EDIT;
import static com.wokabel.app.wokabel.views.UnitSelectAdapter.SELECTED_SUBGROUP_NAME;
import static com.wokabel.app.wokabel.views.UnitSelectAdapter.SELECTED_SUPERGROUP_ID;

public class EditUnit extends AppCompatActivity {

    private EditUnitViewModel model;
    private EditText name;
    private boolean edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_unit);
        name = findViewById(R.id.editText);
        model = ViewModelProviders.of(this).get(EditUnitViewModel.class);
        String intent = this.getIntent().getStringExtra(SELECTED_SUBGROUP_EDIT);
        if(intent!= null){
            if (intent.equals("true")) {
                edit = true;
            }}
        if(edit){
            name.setText(getIntent().getStringExtra(SELECTED_SUBGROUP_NAME));
            setTitle(getString(R.string.edit_of) + " " + getIntent().getStringExtra(SELECTED_SUBGROUP_NAME));
            new ProvideModelEdit(this).execute();
        } else {
            name.setText(getString(R.string.new_unit));
            setTitle(getString(R.string.new_unit));
            Button deletebtn = findViewById(R.id.delete_btn);
            deletebtn.setVisibility(View.GONE);
            new ProvideModelNoEdit(this).execute();
        }
        model.setEdit(edit);
    }

    public void Apply(View view){
        model.setSupergroupName(name.getText().toString());
        finish();
    }

    public void Delete(View view){
        model.delete();
        finish();
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
            EditUnitViewModel model = ViewModelProviders.of(mActivity).get(EditUnitViewModel.class);
            model.setSelectedSubgroup(mActivity.getIntent().getStringExtra(UnitSelectAdapter.SELECTED_SUBGROUP_ID));
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
            EditUnitViewModel model = ViewModelProviders.of(mActivity).get(EditUnitViewModel.class);
            model.setSelectedSupergroup(mActivity.getIntent().getStringExtra(SELECTED_SUPERGROUP_ID));
            model.setSelectedSubgroup();
            return null;
        }
    }
}
