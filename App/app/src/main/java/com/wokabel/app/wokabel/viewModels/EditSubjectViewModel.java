package com.wokabel.app.wokabel.viewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.util.Log;

import com.wokabel.app.wokabel.models.Supergroup;
import com.wokabel.app.wokabel.services.room.DatabaseAdapter;

public class EditSubjectViewModel extends AndroidViewModel {

    private Supergroup selectedSupergroup;
    private DatabaseAdapter adapter;
    public EditSubjectViewModel(Application application){
        super(application);
        adapter = new DatabaseAdapter(application);
    }

    public Supergroup getSelectedSupergroup() {
        return selectedSupergroup;
    }

    public void setSelectedSupergroup(String ID) {
        this.selectedSupergroup = adapter.getSupergroupbyId(ID);
        Log.d("ESViewModel",getSelectedSupergroup().getName());
    }


}
