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
        db = new DatabaseAdapter(application);
    }

    public void setSelectedSupergroup(String ID){
        selectedSupergroup = db.getSupergroupbyId(ID);
        Log.d("UnitSelectVM",String.valueOf(subgroups==null)+"bevore set");
        setSubgroups(db.getSubgroupbySupergroup(selectedSupergroup.getId()));
        Log.d("UnitSelectVM",String.valueOf(subgroups==null)+"after set");
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

    private static class LoadData extends AsyncTask<Void, Void, Void> {
        LoadData() {

        }
        @Override
        protected Void doInBackground(final Void ...params){
            return null;
        }
    }
}
