package com.wokabel.app.wokabel.viewModels;
// homeworx ist ein viel besseres projekt :)
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.os.AsyncTask;

import com.wokabel.app.wokabel.models.Subgroup;
import com.wokabel.app.wokabel.models.Supergroup;
import com.wokabel.app.wokabel.services.room.DatabaseAdapter;

public class EditUnitViewModel extends AndroidViewModel {

    private DatabaseAdapter adapter;
    private Supergroup selectedSupergroup;
    private Subgroup selectedSubgroup;
    private boolean edit;

    public EditUnitViewModel(Application application){
        super(application);
        new SetAdapter(this,application).execute();
    }

    public Subgroup getSelectedSubgroup(){
        return selectedSubgroup;
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

    public void setSelectedSubgroup(String ID) {
        selectedSubgroup = adapter.getSubgroupbyIdAsObject(ID);
        new UpdateData(adapter,this, edit).execute();
    }

    public void setSupergroupName(String name){
        selectedSubgroup.setName(name);
        new UpdateData(adapter,this, edit).execute();
    }
    public void setSelectedSubgroup(){
        selectedSubgroup = new Subgroup("Default Subgroup",selectedSupergroup.getId());
        new UpdateData(adapter,this,edit).execute();
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public void setSupergroup(String id) {
        selectedSupergroup = adapter.getSupergroupbyIdAsObject(id);
    }

    public com.wokabel.app.wokabel.models.Supergroup getSelectedSupergroup() {
        return selectedSupergroup;
    }

    public void setSelectedSupergroup(String iSelectedSupergroup) {
        new SupergroupData(adapter, this, iSelectedSupergroup).execute();
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

    private static class SupergroupData extends AsyncTask<Void, Void, Void> {

        private final DatabaseAdapter mDb;
        private EditUnitViewModel mModel;
        private String ID;

        SupergroupData(DatabaseAdapter db, EditUnitViewModel model, String id) {
            mDb = db;
            mModel = model;
            ID = id;
        }
        @Override
        protected Void doInBackground(final Void... params) {
            mModel.selectedSupergroup = mDb.getSupergroupbyIdAsObject(ID);
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
