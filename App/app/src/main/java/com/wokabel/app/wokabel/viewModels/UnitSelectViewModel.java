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

    public void setSelectedSupergroup(String ID){
        //Abfrage an Datenbank getSupergroupbyId(ID)
        selectedSupergroup = null;
    }

    public void setSelectedSubgrooup(LiveData<Subgroup> selectedSubgroup) {
        this.selectedSubgrooup = selectedSubgroup;
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
