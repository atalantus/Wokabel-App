package com.wokabel.app.wokabel.viewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import com.wokabel.app.wokabel.models.Supergroup;
import com.wokabel.app.wokabel.services.room.DatabaseAdapter;

public class EditSubjectViewModel extends AndroidViewModel {

    private Supergroup selectedSuptergroup;
    private DatabaseAdapter adapter;
    public EditSubjectViewModel(Application application){
        super(application);
        adapter = new DatabaseAdapter(application);
    }

    public Supergroup getSelectedSuptergroup() {
        return selectedSuptergroup;
    }

    public void setSelectedSuptergroup(String ID) {
        this.selectedSuptergroup = adapter.getSupergroupbyId(ID);
    }


}
