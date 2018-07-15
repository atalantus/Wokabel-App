package com.wokabel.app.wokabel.services.room;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.util.Log;

import com.wokabel.app.wokabel.models.Subgroup;
import com.wokabel.app.wokabel.models.Supergroup;
import com.wokabel.app.wokabel.models.Vocable;

import java.util.List;

public class DatabaseAdapter {
    private WokabelDatabase db;
    private VocableDao vocdao;
    private SubgroupDao subdao;
    private SupergroupDao supdao;

    public DatabaseAdapter(Application application){
        db = WokabelDatabase.create(application);
        vocdao = db.getVocableDao();
        subdao = db.getSubgroupDao();
        supdao = db.getSupergroupDao();
        new LoadData(this).execute();
    }

    public LiveData<List<Vocable>> getAllVocables(){
        return vocdao.getAllVocables();
    }

    public LiveData<List<Subgroup>> getAllSubgroups(){
        return subdao.getAllSubgroups();
    }

    public LiveData<List<Supergroup>> getAllSupergroups(){
        return supdao.getAllSupergroups();
    }

    public LiveData<Vocable> getVocablebyId(String id){
        return vocdao.getVocableById(id);
    }

    public LiveData<Subgroup> getSubgroupbyId(String id){
        return subdao.getSubgroupById(id);
    }

    public LiveData<Supergroup> getSupergroupbyId(String id){
        return supdao.getSupergroupById(id);
    }

    public LiveData<List<Vocable>> getVocablesbySubgroup(String id){
        return vocdao.getVocablesbySubgroup(id);
    }

    public LiveData<List<Subgroup>> getSubgroupbySupergroup(String id){
        return subdao.getSubgroupsbySupergroup(id);
    }


    public void updateVocable(Vocable... vocables){
        vocdao.updateVocable(vocables);
    }

    public void updateSubgroup(Subgroup... subgroups){
        subdao.updateSubgroup(subgroups);
    }

    public void updateSupergroup(Supergroup... supergroups){
        supdao.updateSupergroup(supergroups);
    }


    Vocable insertVocable(Vocable vocable){
        vocdao.insert(vocable);
        return vocable;
    }

    List<Vocable> insertAllVocables(List<Vocable> vocables){
        vocdao.insertAll(vocables);
        return vocables;
    }

    Subgroup insertSubgroup(Subgroup subgroup){
        subdao.insert(subgroup);
        return subgroup;
    }

    List<Subgroup> insertAllSubgroups(List<Subgroup> subgroups){
        subdao.insertAll(subgroups);
        return subgroups;
    }

    Supergroup insertSupergroup(Supergroup supergroup){
        supdao.insert(supergroup);
        return supergroup;
    }

    List<Supergroup> insertAllSupergroups(List<Supergroup> supergroups){
        supdao.insertAll(supergroups);
        return supergroups;
    }


    public void deleteDatabaseContent(){
        vocdao.deleteAll();
        subdao.deleteAll();
        supdao.deleteAll();
    }

    boolean checkforContentSupergroup(){

        if(supdao.getSupergroupList().isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    boolean checkforContentSubgroup(){

        if(subdao.getSubgroupList().isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    boolean checkforContentVocable(){

        if(vocdao.getVocableList().isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    boolean checkforContentDatabase(){

        if(checkforContentSupergroup() || checkforContentSubgroup() || checkforContentVocable()){
            return true;
        }else {
            return false;
        }
    }

    private static class LoadData extends AsyncTask<Void, Void, Void> {

        private final DatabaseAdapter mDb;

        LoadData(DatabaseAdapter db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            //load data if necessary
            mDb.deleteDatabaseContent();
            mDb.insertSupergroup(new Supergroup("Test","1"));
            mDb.insertSupergroup(new Supergroup("Test2","2"));
            Log.d("DB Adapter","inserted Supergroups");
            return null;
        }
    }

}
