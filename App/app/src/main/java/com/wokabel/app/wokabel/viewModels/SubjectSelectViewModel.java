package com.wokabel.app.wokabel.viewModels;

import android.arch.lifecycle.LiveData;

import com.wokabel.app.wokabel.models.Supergroup;

public class SubjectSelectViewModel {

    private LiveData<Supergroup> selectedSupergroup;

    public LiveData<Supergroup> getSelectedSupergroup() {
        return selectedSupergroup;
    }

    public void setSelectedSupergroup(LiveData<Supergroup> selectedSupergroup) {
        this.selectedSupergroup = selectedSupergroup;
    }
}
