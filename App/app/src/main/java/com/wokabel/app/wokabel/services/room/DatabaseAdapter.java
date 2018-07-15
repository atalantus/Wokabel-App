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

    //Query Methods
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

    //Update Methods
    public void updateVocable(Vocable... vocables){
        vocdao.updateVocable(vocables);
    }

    public void updateSubgroup(Subgroup... subgroups){
        subdao.updateSubgroup(subgroups);
    }

    public void updateSupergroup(Supergroup... supergroups){
        supdao.updateSupergroup(supergroups);
    }

    //Insert Methods
    public Vocable insertVocable(Vocable vocable){
        vocdao.insert(vocable);
        return vocable;
    }

    public List<Vocable> insertAllVocables(List<Vocable> vocables){
        vocdao.insertAll(vocables);
        return vocables;
    }

    public Subgroup insertSubgroup(Subgroup subgroup){
        subdao.insert(subgroup);
        return subgroup;
    }

    public List<Subgroup> insertAllSubgroups(List<Subgroup> subgroups){
        subdao.insertAll(subgroups);
        return subgroups;
    }

    public Supergroup insertSupergroup(Supergroup supergroup){
        supdao.insert(supergroup);
        return supergroup;
    }

    public List<Supergroup> insertAllSupergroups(List<Supergroup> supergroups){
        supdao.insertAll(supergroups);
        return supergroups;
    }

    //Delete Methods
    public void deleteDatabaseContent(){
        vocdao.deleteAll();
        subdao.deleteAll();
        supdao.deleteAll();
    }

    public void deleteAllVocables(){
        vocdao.deleteAll();
    }

    public void deleteAllSubgroups(){
        subdao.deleteAll();
    }

    public void deleteSupergroups(){
        supdao.deleteAll();
    }

    public void deleteVocablebyId(String id){
        vocdao.deletebyId(id);
    }

    public void deleteSubgroupbyId(String id){
        subdao.deletebyId(id);
    }

    public void deleteSupergroupbyId(String id){
        supdao.deletebyId(id);
    }

    public void deleteVocable(Vocable... vocables){
        vocdao.deleteVocable(vocables);
    }

    public void deleteSubgroup(Subgroup... subgroups){
        subdao.deleteSubgroup(subgroups);
    }

    public void deleteSupergroup(Supergroup... supergroups){
        supdao.deleteSupergroup(supergroups);
    }



    //Bool Methods
    public boolean checkforContentSupergroup(){

        if(supdao.getSupergroupList().isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    public boolean checkforContentSubgroup(){

        if(subdao.getSubgroupList().isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    public boolean checkforContentVocable(){

        if(vocdao.getVocableList().isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    public boolean checkforContentDatabase(){

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
