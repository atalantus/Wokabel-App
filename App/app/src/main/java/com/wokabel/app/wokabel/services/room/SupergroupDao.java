package com.wokabel.app.wokabel.services.room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.wokabel.app.wokabel.models.Supergroup;

import java.util.ArrayList;
import java.util.List;
@Dao
public interface SupergroupDao {

    @Insert
    void insert(Supergroup supergroup);

    @Update
    void updateSupergroup(Supergroup... supergroups);

    @Query("DELETE FROM supergrouplist")
    void deleteAll();

    @Query("SELECT * FROM supergrouplist WHERE id = :id")
    Supergroup getSupergroupbyId(String id);

    @Query("SELECT * FROM supergrouplist")
    LiveData<List<Supergroup>> getAllSupergroups();

    @Query("SELECT * from supergrouplist")
    List<Supergroup> getSupergroupList();

    @Query("SELECT * FROM supergrouplist")
    Supergroup [] getAllSupergroupsArray();

    @Query("SELECT * FROM supergrouplist")
    List<Supergroup> getAllSupergroupsArrayList();
}
