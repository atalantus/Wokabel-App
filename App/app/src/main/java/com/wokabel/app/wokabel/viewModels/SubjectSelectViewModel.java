package com.wokabel.app.wokabel.viewModels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.wokabel.app.wokabel.models.Supergroup;

import java.util.ArrayList;
import java.util.List;

public class SubjectSelectViewModel extends ViewModel {

    private LiveData<List<Supergroup>> Supergroups;

    public SubjectSelectViewModel(){
        //Abfrage aus Datenbank
        Supergroups = null;
    }


    public ArrayList<String> getSupergroups(){
        ArrayList<String> list = new ArrayList<>();
        list.add("Englisch");
        list.add("Französisch");
        list.add("Test");
        //list = ((ArrayList<String>)Supergroups.getValue().getAll());
        return list;
    }

    public ArrayList<String> getAllIDs(){
        //list =
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        return list;
    }
}
