package com.wokabel.app.wokabel.services.room;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.wokabel.app.wokabel.models.Subgroup;
import com.wokabel.app.wokabel.models.Supergroup;
import com.wokabel.app.wokabel.models.Vocable;

import java.util.List;

public class DatabaseAdapter {
    private WokabelDatabase db;
    private VocableDao vocdao;
    private SubgroupDao subdao;
    private SupergroupDao supdao;

    DatabaseAdapter(Application application){
        db = WokabelDatabase.getInstance(application);
        vocdao = db.getVocableDao();
        subdao = db.getSubgroupDao();
        supdao = db.getSupergroupDao();
    }

    LiveData<List<Vocable>> getAllVocables(){
        return vocdao.getAllVocables();
    }

    LiveData<List<Subgroup>> getAllSubgroups(){
        return subdao.getAllSubgroups();
    }

    LiveData<List<Supergroup>> getAllSupergroups(){
        return supdao.getAllSupergroups();
    }

    Vocable getVocablebyId(String id){
        return vocdao.getVocablebyId(id);
    }

    Subgroup getSubgroupbyId(String id){
        return subdao.getSubgroupbyId(id);
    }

    Supergroup getSupergroupbyId(String id){
        return supdao.getSupergroupbyId(id);
    }

    LiveData<List<Vocable>> getVocablesbySubgroup(String id){
        return vocdao.getVocablesbySubgroup(id);
    }

    LiveData<List<Subgroup>> getSubgroupbySupergroup(String id){
        return subdao.getSubgroupsbySupergroup(id);
    }

    void insertVocable(Vocable vocable){
        vocdao.insert(vocable);
    }

    void insertSubgroup(Subgroup subgroup){
        subdao.insert(subgroup);
    }

    void insertSupergroup(Supergroup supergroup){
        supdao.insert(supergroup);
    }

    void deleteDatabaseContent(){
        vocdao.deleteAll();
        subdao.deleteAll();
        supdao.deleteAll();
    }

    boolean checkforContentSupergroup(){

        if(supdao.getSupergroupList().isEmpty()){
            return false;
        }
        return true;
    }

    boolean checkforContentSubgroup(){

        if(subdao.getSubgroupList().isEmpty()){
            return false;
        }
        return true;
    }

    boolean checkforContentVocable(){

        if(vocdao.getVocableList().isEmpty()){
            return false;
        }
        return true;
    }

    boolean checkforContentDatabase(){

        if(checkforContentSupergroup() || checkforContentSubgroup() || checkforContentVocable()){
            return true;
        }
        return false;
    }
}
