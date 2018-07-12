package com.wokabel.app.wokabel.viewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.wokabel.app.wokabel.models.Subgroup;
import com.wokabel.app.wokabel.models.Supergroup;
import com.wokabel.app.wokabel.services.room.DatabaseAdapter;

import java.util.List;

public class UnitSelectViewModel extends AndroidViewModel {
    private Supergroup selectedSupergroup;
    private LiveData<List<Subgroup>> subgroups;
    private DatabaseAdapter adapter;

    public UnitSelectViewModel(Application application){
        super(application);
        adapter = new DatabaseAdapter(application);
    }

    public void setSelectedSupergroup(String ID){
        selectedSupergroup = adapter.getSupergroupbyId(ID);
        setSubgroups(adapter.getSubgroupbySupergroup(selectedSupergroup.getId()));
    }

    public LiveData<List<Subgroup>> getSubgroups() {
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
