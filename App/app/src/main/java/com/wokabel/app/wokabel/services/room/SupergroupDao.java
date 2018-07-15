package com.wokabel.app.wokabel.services.room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.wokabel.app.wokabel.models.Supergroup;
import com.wokabel.app.wokabel.models.Vocable;

import java.util.List;
@Dao
public interface SupergroupDao {

    //Insert Methods
    @Insert
    void insert(Supergroup supergroup);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Supergroup> supergroups);


    //Update Methods
    @Update
    void updateSupergroup(Supergroup... supergroups);


    //Delete Methods
    @Query("DELETE FROM supergrouplist")
    void deleteAll();

    @Query("DELETE FROM subgrouplist WHERE id = :id")
    void deletebyId(String id);

    @Delete
    void deleteSupergroup(Supergroup... supergroups);


    //Query Methods
    @Query("SELECT * FROM supergrouplist WHERE id = :id")
    LiveData<Supergroup> getSupergroupById(String id);

    @Query("SELECT * FROM supergrouplist WHERE id = :id")
    Supergroup getSupergroupByIdAsObject(String id);

    @Query("SELECT * FROM supergrouplist")
    LiveData<List<Supergroup>> getAllSupergroups();

    @Query("SELECT * from supergrouplist")
    List<Supergroup> getSupergroupList();

    @Query("SELECT * FROM supergrouplist")
    Supergroup [] getAllSupergroupsArray();

    @Query("SELECT * FROM supergrouplist")
    List<Supergroup> getAllSupergroupsArrayList();
}
