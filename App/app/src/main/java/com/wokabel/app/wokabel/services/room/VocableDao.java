package com.wokabel.app.wokabel.services.room;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.wokabel.app.wokabel.models.Vocable;

import java.util.List;

@Dao
public interface VocableDao {

    @Insert
    void insert(Vocable vocable);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Vocable> vocables);

    @Query("DELETE FROM vocablist")
    void deleteAll();

    @Query("DELETE FROM vocablist WHERE id = :id")
    void deletebyId(String id);

    @Query("SELECT * from vocablist WHERE id = :id")
    LiveData<Vocable> getVocableById(String id);

    @Query("SELECT * from vocablist")
    LiveData<List<Vocable>> getAllVocables();

    @Query("SELECT * from vocablist")
    List<Vocable> getVocableList();

    @Query("SELECT * from vocablist WHERE subgroupid = :subgroupid")
    LiveData<List<Vocable>> getVocablesbySubgroup(String subgroupid);
}
