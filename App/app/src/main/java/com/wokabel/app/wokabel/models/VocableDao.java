package com.wokabel.app.wokabel.models;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface VocableDao {

    @Insert
    void insert(Vocable vocable);

    @Query("DELETE FROM vocablist")
    void deleteAll();

    @Query("DELETE FROM vocablist WHERE id = :id")
    void deletebyId(String id);

    @Query("SELECT * from vocablist")
    LiveData<List<Vocable>> getAllVocables();

    @Query("SELECT * from vocablist WHERE subgroupid = :subgroupid")
    LiveData<List<Vocable>> getSubgroupVocables(String subgroupid);


}
