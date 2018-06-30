package com.wokabel.app.wokabel.models;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Vocable.class}, version = 1, exportSchema = false)
public abstract class WokabelRoomDatabase extends RoomDatabase {

}