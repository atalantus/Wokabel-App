package com.wokabel.app.wokabel.services.room;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.util.Log;

import com.wokabel.app.wokabel.models.Subgroup;
import com.wokabel.app.wokabel.models.Supergroup;
import com.wokabel.app.wokabel.models.Vocable;

import java.util.List;

/**
 * This class is the access point for working with the Database.
 *
 * @author Jonah Kraushaar, Samuel R&ouml;ttgermann
 * @version 2.2
 *
 */
public class DatabaseAdapter {
    private WokabelDatabase db;
    private VocableDao vocdao;
    private SubgroupDao subdao;
    private SupergroupDao supdao;

    /**
     * the Constructor
     * @param application
     */
    public DatabaseAdapter(Application application){
        db = WokabelDatabase.create(application);
        vocdao = db.getVocableDao();
        subdao = db.getSubgroupDao();
        supdao = db.getSupergroupDao();
        new LoadData(this).execute();
    }

    /**
     * Get all Vocables
     * @return LiveData<List<Vocable>> LiveData containing all Vocables
     */
    public LiveData<List<Vocable>> getAllVocables(){
        return vocdao.getAllVocables();
    }

    /**
     * Get all Subgroups
     * @return LiveData<List<Subgroup>> LiveData containing all Subgroups
     */
    public LiveData<List<Subgroup>> getAllSubgroups(){
        return subdao.getAllSubgroups();
    }

    /**
     * Get all Supergroups
     * @return LiveData<List<Supergroup>>  LiveData containing all Supergroups
     */
    public LiveData<List<Supergroup>> getAllSupergroups(){
        return supdao.getAllSupergroups();
    }

    /**
     * Find a Vocable by its unique ID
     * @param id
     * @return LiveData<Vocable>
     */
    public LiveData<Vocable> getVocablebyId(String id){
        return vocdao.getVocableById(id);
    }

    /**
     * Find a Vocable by its unique ID
     * @param id Vocableid
     * @return Vocable
     */
    public Vocable getVocablebyIdAsObject(String id){
        return vocdao.getVocableByIdAsObject(id);
    }

    /**
     * Find a Subgroup by its unique ID
     * @param id
     * @return LiveData<Subgroup>
     */
    public LiveData<Subgroup> getSubgroupbyId(String id){
        return subdao.getSubgroupById(id);
    }
    /**
     * Find a Subgroup by its unique ID
     * @param id Subgroupid
     * @return Subgroup
     */
    public Subgroup getSubgroupbyIdAsObject(String id){
        return subdao.getSubgroupByIdAsObject(id);
    }
    /**
     * Find a Supergroup by its unique ID
     * @param id Supergroupid
     * @return LiveData<Supergroup>
     */
    public LiveData<Supergroup> getSupergroupbyId(String id){
        return supdao.getSupergroupById(id);
    }

    /**
     * Find a Supergroup by its unique ID
     * @param id Supergroupid
     * @return Supergroup
     */
    public Supergroup getSupergroupbyIdAsObject(String id){
        return supdao.getSupergroupByIdAsObject(id);
    }

    /**
     * Find Vocables by their Subgroup
     * @param id Subgroupid
     * @return LiveData<Vocable>
     */
    public LiveData<List<Vocable>> getVocablesbySubgroup(String id){
        return vocdao.getVocablesbySubgroup(id);
    }

    /**
     * Find Subgroups by their Supergroup
     * @param id Supergroupid
     * @return LiveData<Vocable>
     */
    public LiveData<List<Subgroup>> getSubgroupbySupergroup(String id){
        return subdao.getSubgroupsbySupergroup(id);
    }

    /**
     * Update Vocable/s
     * @param vocables Vocable/s
     */
    public void updateVocable(Vocable... vocables){
        vocdao.updateVocable(vocables);
    }

    /**
     * Update Subgroup/s
     * @param subgroups Subgroup/s
     */
    public void updateSubgroup(Subgroup... subgroups){
        subdao.updateSubgroup(subgroups);
    }

    /**
     * Update Supergroup/s
     * @param supergroups Supergroup/s
     */
    public void updateSupergroup(Supergroup... supergroups){
        supdao.updateSupergroup(supergroups);
    }

    /**
     * Insert one Vocable
     * @param vocable A Vocable Object
     * @return Vocable :The Vocable you inserted
     */
    public Vocable insertVocable(Vocable vocable){
        vocdao.insert(vocable);
        return vocable;
    }

    /**
     *  Override all existing Vocables with a List of Vocables
     * @param vocables A List of Vocables
     * @return List<Vocable> :The List of Vocables you inserted
     */
    public List<Vocable> insertAllVocables(List<Vocable> vocables){
        vocdao.insertAll(vocables);
        return vocables;
    }

    /**
     * Insert one Subgroup
     * @param subgroup A Subgroup Object
     * @return Subgroup :The Subgroup you inserted
     */
    public Subgroup insertSubgroup(Subgroup subgroup){
        subdao.insert(subgroup);
        return subgroup;
    }

    /**
     * Override all existing Subgroups with a List of Subgroups
     * @param subgroups A List of Subgroups
     * @return List<Subgroup> :the List of the Subgroups you inserted
     */
    public List<Subgroup> insertAllSubgroups(List<Subgroup> subgroups){
        subdao.insertAll(subgroups);
        return subgroups;
    }

    /**
     * Insert one Supergroup
     * @param supergroup A Supergroup Object
     * @return Supergroup :The SUpergroup you inserted
     */
    public Supergroup insertSupergroup(Supergroup supergroup){
        supdao.insert(supergroup);
        return supergroup;
    }

    /**
     * Override all existing Supergroups with a List of Supergroups
     * @param supergroups A List of Supergroups
     * @return List<Supergroup> :the List of Supergroups you inserted
     */
    public List<Supergroup> insertAllSupergroups(List<Supergroup> supergroups){
        supdao.insertAll(supergroups);
        return supergroups;
    }

    /**
     * Delete the content of the whole Database
     */
    public void deleteDatabaseContent(){
        vocdao.deleteAll();
        subdao.deleteAll();
        supdao.deleteAll();
    }

    /**
     * Delete all Vocables
     */
    public void deleteAllVocables(){
        vocdao.deleteAll();
    }

    /**
     * Delete all Subgroups
     */
    public void deleteAllSubgroups(){
        subdao.deleteAll();
    }

    /**
     * Delete all Supergroups
     */
    public void deleteSupergroups(){
        supdao.deleteAll();
    }

    /**
     * Delete a certain Vocable by its unique ID
     * @param id The Vocable ID
     */
    public void deleteVocablebyId(String id){
        vocdao.deletebyId(id);
    }

    /**
     * Delete a certain Subgroup by its unique ID
     * @param id the Subgroup ID
     */
    public void deleteSubgroupbyId(String id){
        subdao.deletebyId(id);
    }

    /**
     * Delete a Supergroup by its unique ID
     * @param id the Supergroup ID
     */
    public void deleteSupergroupbyId(String id){
        supdao.deletebyId(id);
    }

    /**
     * Delete (a) Vocable/s
     * @param vocables Vocable/s
     */
    public void deleteVocable(Vocable... vocables){
        vocdao.deleteVocable(vocables);
    }

    /**
     * Delete (a) Subgroup/s
     * @param subgroups Subgroup/s
     */
    public void deleteSubgroup(Subgroup... subgroups){
        subdao.deleteSubgroup(subgroups);
    }

    /**
     * Delete (a) Supergroup/s
     * @param supergroups Supergroup/s
     */
    public void deleteSupergroup(Supergroup... supergroups){
        supdao.deleteSupergroup(supergroups);
    }

    /**
     * Check for the Supergroup Table Emptiness
     * @return True if the Supergrouptable has content
     */
    public boolean checkforContentSupergroup(){

        if(supdao.getSupergroupList().isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    /**
     * Check for the Subgroup Table Emptiness
     * @return True if the Subgrouptable has content
     */
    public boolean checkforContentSubgroup(){

        if(subdao.getSubgroupList().isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    /**
     * Check for the Vocabletable Emptiness
     * @return True if the Vocabletable has content
     */
    public boolean checkforContentVocable(){

        if(vocdao.getVocableList().isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    /**
     * Check for the Database Emptiness
     * @return True if the Database has any entries
     */
    public boolean checkforContentDatabase(){

        if(checkforContentSupergroup() || checkforContentSubgroup() || checkforContentVocable()){
            return true;
        }else {
            return false;
        }
    }

    /**
     * Load Data
     */
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
