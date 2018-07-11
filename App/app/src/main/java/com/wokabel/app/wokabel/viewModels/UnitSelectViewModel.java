package com.wokabel.app.wokabel.viewModels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.wokabel.app.wokabel.models.Subgroup;
import com.wokabel.app.wokabel.models.Supergroup;

import java.util.List;

public class UnitSelectViewModel extends ViewModel {
    private LiveData<Supergroup> selectedSupergroup;
    private LiveData<List<Subgroup>> subgroups;

    public UnitSelectViewModel(){

        //setSubgroups(alle subgroups der selected Supergroup abfragen);
        subgroups = null;
    }

    public void setSelectedSupergroup(String ID){
        //Abfrage an Datenbank getSupergroupbyId(ID)
        selectedSupergroup = null;
    }

    public LiveData<List<Subgroup>> getSubgroups() {
        return subgroups;
    }

    public void setSubgroups(LiveData<List<Subgroup>> subgroups) {
        this.subgroups = subgroups;
    }

    public LiveData<Supergroup> getSelectedSupergroup() {
        return selectedSupergroup;
    }
}
