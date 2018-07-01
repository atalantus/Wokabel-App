package com.wokabel.app.wokabel.services.room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.wokabel.app.wokabel.models.Subgroup;

import java.util.List;
@Dao
public interface SubgroupDao {

    @Insert
    void insert(Subgroup subgroup);

    @Query("DELETE FROM subgrouplist")
    void deleteAll();

    @Query("SELECT * FROM subgrouplist")
    LiveData<List<Subgroup>> getAllSubgroups();

    @Query("SELECT * FROM subgrouplist WHERE supergroupid = :supergroupid")
    LiveData<List<Subgroup>> getSupergroupSubgroups(String supergroupid);
}
