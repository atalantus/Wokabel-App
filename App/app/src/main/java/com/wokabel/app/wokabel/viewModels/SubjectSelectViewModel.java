package com.wokabel.app.wokabel.viewModels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.wokabel.app.wokabel.models.Supergroup;

import java.util.ArrayList;

public class SubjectSelectViewModel extends ViewModel {

    private LiveData<Supergroup> selectedSupergroup;

    public LiveData<Supergroup> getSelectedSupergroup() {
        return selectedSupergroup;
    }

    public void setSelectedSupergroup(LiveData<Supergroup> selectedSupergroup) {
        this.selectedSupergroup = selectedSupergroup;
    }

    public ArrayList<String> getAllSupergroups(){
        ArrayList<String> list = new ArrayList<>();
        list.add("Englisch");
        list.add("Französisch");
        list.add("Test");
        return list;
    }

    public ArrayList<String> getAllIDs(){
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        return list;
    }
}
