package com.wokabel.app.wokabel.services.room;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

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

    public Vocable getVocablebyId(String id){
        return vocdao.getVocablebyId(id);
    }

    public Subgroup getSubgroupbyId(String id){
        return subdao.getSubgroupbyId(id);
    }

    public Supergroup getSupergroupbyId(String id){
        return supdao.getSupergroupbyId(id);
    }

    public LiveData<List<Vocable>> getVocablesbySubgroup(String id){
        return vocdao.getVocablesbySubgroup(id);
    }

    public LiveData<List<Subgroup>> getSubgroupbySupergroup(String id){
        return subdao.getSubgroupsbySupergroup(id);
    }

    public Vocable insertVocable(Vocable vocable){
        vocdao.insert(vocable);
        return vocable;
    }

    public Subgroup insertSubgroup(Subgroup subgroup){
        subdao.insert(subgroup);
        return subgroup;
    }

    public Supergroup insertSupergroup(Supergroup supergroup){
        supdao.insert(supergroup);
        return supergroup;
    }

    public void deleteDatabaseContent(){
        vocdao.deleteAll();
        subdao.deleteAll();
        supdao.deleteAll();
    }

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

    boolean checkforContentDatabase(){

        if(checkforContentSupergroup() || checkforContentSubgroup() || checkforContentVocable()){
            return true;
        }else {
            return false;
        }
    }

    public WokabelDatabase getDatabase(){
        return db;
    }

    private static class LoadData extends AsyncTask<Void, Void, Void> {

        private final DatabaseAdapter mDb;

        LoadData(DatabaseAdapter db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            //load data if necessary
            /*Log.d("DatabaseAdapter", mDb.getSupergroupbyId("1").getName());
            mDb.deleteDatabaseContent();
            mDb.insertSupergroup(new Supergroup("Test", "1", "null"));
            mDb.insertSupergroup(new Supergroup("Test2", "2", "null"));
            mDb.insertSubgroup(new Subgroup("SubTest","1"));
            mDb.insertSubgroup(new Subgroup("SubTest2","1"));
            mDb.insertSubgroup(new Subgroup("SubTest2","2"));
            mDb.insertSubgroup(new Subgroup("SubTest","2"));
            Log.d("DB Adapter","inserted Super/Subgroups");*/
            return null;
        }
    }
}
