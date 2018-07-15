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
        adapter = new DatabaseAdapter(application);
    }

    public Supergroup getSelectedSupergroup() {
        return selectedSupergroup;
    }

    public void setSelectedSupergroup(String ID) {
        this.selectedSupergroup = adapter.getSupergroupbyId(ID);
        Log.d("ESViewModel", getSelectedSupergroup().getName());
        new LoadData(adapter,this, edit).execute();
    }

    public void setSelectedSupergroup(){
        selectedSupergroup = new Supergroup("new Supergroup","icon");
    }

    public void setSupergroupName(String name){
        selectedSupergroup.setName(name);
        Log.d("ESVM",selectedSupergroup.getName());
        new LoadData(adapter,this, edit).execute();

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

    private static class LoadData extends AsyncTask<Void, Void, Void> {

        private final DatabaseAdapter mDb;
        private EditSubjectViewModel mModel;
        private boolean edit;

        LoadData(DatabaseAdapter db, EditSubjectViewModel model, boolean Iedit) {
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
}
