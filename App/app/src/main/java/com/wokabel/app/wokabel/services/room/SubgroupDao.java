package com.wokabel.app.wokabel.services.room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.wokabel.app.wokabel.models.Subgroup;

import java.util.List;
@Dao
public interface SubgroupDao {

    //Insert Methods
    @Insert
    void insert(Subgroup subgroup);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Subgroup> subgroups);


    //Update Methods
    @Update
    void updateSubgroup(Subgroup... subgroups);


    //Delete Methods
    @Query("DELETE FROM subgrouplist")
    void deleteAll();

    @Delete
    void deleteSubgroup(Subgroup... subgroups);

    @Query("DELETE FROM subgrouplist WHERE id = :id")
    void deletebyId(String id);


    //Query Methods
    @Query("SELECT * from subgrouplist WHERE id = :id")
    LiveData<Subgroup> getSubgroupById(String id);

    @Query("SELECT * from subgrouplist WHERE id = :id")
    Subgroup getSubgroupByIdAsObject(String id);

    @Query("SELECT * FROM subgrouplist")
    LiveData<List<Subgroup>> getAllSubgroups();

    @Query("SELECT * from subgrouplist")
    List<Subgroup> getSubgroupList();

    @Query("SELECT * FROM subgrouplist WHERE supergroupid = :supergroupid")
    LiveData<List<Subgroup>> getSubgroupsbySupergroup(String supergroupid);

}
