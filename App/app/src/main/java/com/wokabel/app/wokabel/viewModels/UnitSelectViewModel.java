package com.wokabel.app.wokabel.viewModels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.wokabel.app.wokabel.models.Subgroup;
import com.wokabel.app.wokabel.models.Supergroup;

import java.util.ArrayList;
import java.util.List;

public class UnitSelectViewModel extends ViewModel {
    private LiveData<Supergroup> selectedSupergroup;
    private LiveData<Subgroup> selectedSubgrooup;
    private LiveData<List<Subgroup>> subgroups;
    private ArrayList<String> ids;

    public UnitSelectViewModel(){

        //alle subgroups der selected Supergroup abfragen
        subgroups = null;
        ids = new ArrayList<>();
        ids.add("Englisch");
        ids.add("Französisch");
        ids.add("toller Test");
    }

    public void setSelectedSupergroup(LiveData<Supergroup> selectedSupergroup){
        selectedSupergroup = selectedSupergroup;
    }

    public void setSeectedSubgrooup(LiveData<Subgroup> selectedSubgroup) {
        this.selectedSubgrooup = selectedSubgroup;
    }

    public LiveData<List<Subgroup>> getSubgroups() {
        return subgroups;
    }

    public void setSubgroups(LiveData<List<Subgroup>> subgroups) {
        this.subgroups = subgroups;
    }

    public String getSupergroupbyID(String ID) {
        return ids.get(Integer.parseInt(ID)-1);
    }

    public LiveData<Supergroup> getSelectedSupergroup() {
        return selectedSupergroup;
    }
}
