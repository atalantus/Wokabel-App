package com.wokabel.app.wokabel.viewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.os.AsyncTask;
import android.util.Log;

import com.wokabel.app.wokabel.models.Supergroup;
import com.wokabel.app.wokabel.services.room.DatabaseAdapter;

public class EditSubjectViewModel extends AndroidViewModel {

    private Supergroup selectedSupergroup;
    private DatabaseAdapter adapter;
    private boolean edit;
    public EditSubjectViewModel(Application application){
        super(application);
        new SetAdapter(this, application).execute();
    }

    public Supergroup getSelectedSupergroup() {
        return selectedSupergroup;
    }

    public void setSelectedSupergroup(String ID) {
        selectedSupergroup = adapter.getSupergroupbyIdAsObject(ID);
        Log.d("ESViewModel", getSelectedSupergroup().getName());
        new UpdateData(adapter,this, edit).execute();
    }

    public void setSelectedSupergroup(){
        selectedSupergroup = new Supergroup("new Supergroup","icon");
    }

    public void setSupergroupName(String name){
        selectedSupergroup.setName(name);
        Log.d("ESVM",selectedSupergroup.getName());
        new UpdateData(adapter,this, edit).execute();

    }
    public void Apply(){
        Log.d("t","t");
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public void delete(){
        new DeleteData(adapter,this).execute();
    }
    public void setAdapter(DatabaseAdapter iadapter){
        adapter = iadapter;
    }

    private static class UpdateData extends AsyncTask<Void, Void, Void> {

        private final DatabaseAdapter mDb;
        private EditSubjectViewModel mModel;
        private boolean edit;

        UpdateData(DatabaseAdapter db, EditSubjectViewModel model, boolean Iedit) {
            mDb = db;
            mModel = model;
            edit = Iedit;
        }

        @Override
        protected Void doInBackground(final Void... params) {

            if(edit){
                mDb.getDatabase().getSupergroupDao().updateSupergroup(mModel.selectedSupergroup);
            } else{
                mDb.insertSupergroup(mModel.selectedSupergroup);
            }
            return null;
        }
    }
    private static class DeleteData extends AsyncTask<Void, Void, Void> {

        private final DatabaseAdapter mDb;
        private EditSubjectViewModel mModel;

        DeleteData(DatabaseAdapter db, EditSubjectViewModel model) {
            mDb = db;
            mModel = model;
        }

        @Override
        protected Void doInBackground(final Void... params) {

            mDb.deleteSupergroupbyId(mModel.selectedSupergroup.getId());
            return null;
        }
    }
    private static class SetAdapter extends AsyncTask<Void, Void, Void> {

        private EditSubjectViewModel mModel;
        private Application mApplication;

        SetAdapter(EditSubjectViewModel model, Application application) {
            mModel = model;
            mApplication = application;

        }

        @Override
        protected Void doInBackground(final Void... params) {

            mModel.setAdapter(new DatabaseAdapter(mApplication));
            return null;
        }
    }
}
