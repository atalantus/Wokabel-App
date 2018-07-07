package com.wokabel.app.wokabel.viewModels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.wokabel.app.wokabel.models.Subgroup;
import com.wokabel.app.wokabel.models.Supergroup;

public class UnitSelectViewModel extends ViewModel {
    private LiveData<Supergroup> selectedSupergroup;
    private LiveData<Subgroup> seectedSubgrooup;

    public void setSelectedSupergroup(LiveData<Supergroup> iselectedSupergroup){
        selectedSupergroup = iselectedSupergroup;
    }
    public void setSeectedSubgrooup(LiveData<Subgroup> seectedSubgrooup) {
        this.seectedSubgrooup = seectedSubgrooup;
    }

}
