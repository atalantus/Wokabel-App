package com.wokabel.app.wokabel.viewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.util.Log;

import com.wokabel.app.wokabel.models.Supergroup;
import com.wokabel.app.wokabel.services.room.DatabaseAdapter;

import java.util.List;

public class SubjectSelectViewModel extends AndroidViewModel {

    private LiveData<List<Supergroup>> Supergroups;
    private DatabaseAdapter adapter;

    public SubjectSelectViewModel(Application application){
        super(application);
        //Abfrage aus Datenbank
        Log.d("SSVM","Adapter erstellt");
        new SetAdapter(this,application).execute();
    }

    public LiveData<List<Supergroup>> getSupergroups(){
        return adapter.getAllSupergroups();
    }

    public void setAdapter(DatabaseAdapter adapter) {
        this.adapter = adapter;
    }

    public void setSupergroups(LiveData<List<Supergroup>> supergroups) {
        Supergroups = supergroups;
    }

    private static class SetAdapter extends AsyncTask<Void, Void, Void> {

        private SubjectSelectViewModel mModel;
        private Application mApplication;

        SetAdapter(SubjectSelectViewModel model, Application application) {
            mModel = model;
            mApplication = application;

        }

        @Override
        protected Void doInBackground(final Void... params) {

            mModel.setAdapter(new DatabaseAdapter(mApplication));
            return null;
        }
    }
}
