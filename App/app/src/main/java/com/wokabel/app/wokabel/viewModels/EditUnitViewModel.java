package com.wokabel.app.wokabel.viewModels;
// homeworx ist ein viel besseres projekt :)
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.os.AsyncTask;
import android.util.Log;

import com.wokabel.app.wokabel.models.Subgroup;
import com.wokabel.app.wokabel.services.room.DatabaseAdapter;

public class EditUnitViewModel extends AndroidViewModel {

    private DatabaseAdapter adapter;
    private Subgroup selectedSubgroup;
    private boolean edit;

    public EditUnitViewModel(Application application){
        super(application);
        new SetAdapter(this,application);
    }

    public void delete(){
        new DeleteData(adapter,this).execute();
    }

    public DatabaseAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(DatabaseAdapter adapter) {
        this.adapter = adapter;
    }

    public void setSelectedSubgroup(Subgroup selectedSubgroup) {
        this.selectedSubgroup = selectedSubgroup;
    }

    public void setSupergroupName(String name){
        selectedSubgroup.setName(name);
        Log.d("ESVM",selectedSubgroup.getName());
        new UpdateData(adapter,this, edit).execute();
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    private static class SetAdapter extends AsyncTask<Void, Void, Void> {

        private EditUnitViewModel mModel;
        private Application mApplication;

        SetAdapter(EditUnitViewModel model, Application application) {
            mModel = model;
            mApplication = application;
        }

        @Override
        protected Void doInBackground(final Void... params) {

            mModel.setAdapter(new DatabaseAdapter(mApplication));
            return null;
        }
    }
    private static class DeleteData extends AsyncTask<Void, Void, Void> {

        private final DatabaseAdapter mDb;
        private EditUnitViewModel mModel;

        DeleteData(DatabaseAdapter db, EditUnitViewModel model) {
            mDb = db;
            mModel = model;
        }
        @Override
        protected Void doInBackground(final Void... params) {
            mDb.deleteSubgroupbyId(mModel.selectedSubgroup.getId());
            return null;
        }
    }
    private static class UpdateData extends AsyncTask<Void, Void, Void> {

        private final DatabaseAdapter mDb;
        private EditUnitViewModel mModel;
        private boolean edit;

        UpdateData(DatabaseAdapter db, EditUnitViewModel model, boolean Iedit) {
            mDb = db;
            mModel = model;
            edit = Iedit;
        }

        @Override
        protected Void doInBackground(final Void... params) {

            if(edit){
                mDb.getDatabase().getSubgroupDao().updateSubgroup(mModel.selectedSubgroup);
            } else{
                mDb.insertSubgroup(mModel.selectedSubgroup);
            }
            return null;
        }
    }
}
