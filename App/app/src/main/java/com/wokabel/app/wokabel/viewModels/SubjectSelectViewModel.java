package com.wokabel.app.wokabel.viewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.util.Log;

import com.wokabel.app.wokabel.models.Supergroup;
import com.wokabel.app.wokabel.services.room.DatabaseAdapter;

import java.util.List;

public class SubjectSelectViewModel extends AndroidViewModel {

    private LiveData<List<Supergroup>> Supergroups;

    public SubjectSelectViewModel(Application application){
        super(application);
        //Abfrage aus Datenbank
        DatabaseAdapter adapter = new DatabaseAdapter(application);
        Supergroups = adapter.getAllSupergroups();
    }

    public LiveData<List<Supergroup>> getSupergroups(){
        Log.d("SubjectVM", "Supergroups called from DB");
        return Supergroups;
    }
}
