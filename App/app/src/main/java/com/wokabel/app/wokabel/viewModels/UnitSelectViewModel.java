package com.wokabel.app.wokabel.viewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.util.Log;

import com.wokabel.app.wokabel.models.Subgroup;
import com.wokabel.app.wokabel.models.Supergroup;
import com.wokabel.app.wokabel.services.room.DatabaseAdapter;

import java.util.List;

public class UnitSelectViewModel extends AndroidViewModel {
    private Supergroup selectedSupergroup;
    private LiveData<List<Subgroup>> subgroups;
    private DatabaseAdapter db;

    public UnitSelectViewModel(Application application){
        super(application);
        new LoadData(this, application).execute();

    }

    public void setSelectedSupergroup(String ID) {
        selectedSupergroup = db.getSupergroupbyIdAsObject(ID);
        setSubgroups(db.getSubgroupbySupergroup(selectedSupergroup.getId()));
    }

    public LiveData<List<Subgroup>> getSubgroups() {
        Log.d("UnitSelectVM",String.valueOf(subgroups==null)+" getSubgroups");
        return subgroups;
    }

    private void setSubgroups(LiveData<List<Subgroup>> subgroups) {
        this.subgroups = subgroups;
    }

    public String getSelectedSupergroup() {
        String result;
        result = selectedSupergroup.getName();
        if (selectedSupergroup == null){
            result = "Test";
        }
        return result;
    }

    public void setDb(DatabaseAdapter adapter){
        db = adapter;
    }

    private static class LoadData extends AsyncTask<Void, Void, Void> {
        Application mApplication;
        UnitSelectViewModel mModel;

        LoadData(UnitSelectViewModel model, Application application) {
            mApplication = application;
            mModel = model;

        }
        @Override
        protected Void doInBackground(final Void ...params){
            mModel.setDb(new DatabaseAdapter(mApplication));
            return null;
        }
    }
}
