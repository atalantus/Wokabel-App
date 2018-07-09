package com.wokabel.app.wokabel.viewModels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.wokabel.app.wokabel.models.Supergroup;

public class SubjectSelectViewModel extends ViewModel {

    private LiveData<Supergroup> selectedSupergroup;

    public LiveData<Supergroup> getSelectedSupergroup() {
        return selectedSupergroup;
    }

    public void setSelectedSupergroup(LiveData<Supergroup> selectedSupergroup) {
        this.selectedSupergroup = selectedSupergroup;
    }
}
