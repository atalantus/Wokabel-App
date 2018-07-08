package com.wokabel.app.wokabel.viewModels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.wokabel.app.wokabel.models.Subgroup;
import com.wokabel.app.wokabel.models.Supergroup;

import java.util.List;

public class UnitSelectViewModel extends ViewModel {
    private LiveData<Supergroup> selectedSupergroup;
    private LiveData<Subgroup> selectedSubgrooup;
    private LiveData<List<Subgroup>> subgroups;

    public UnitSelectViewModel(){
        //alle subgroups der selected Supergroup abfragen
        subgroups = null;
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
}
