package com.wokabel.app.wokabel.models;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

@Database(entities = {Vocable.class, Subgroup.class, Supergroup.class}, version = 1, exportSchema = false)
@TypeConverters(Typeconverter.class)
public abstract class WokabelDatabase extends RoomDatabase {

    private static final String DB_NAME = "wokabelDatabase.db";
    private static volatile WokabelDatabase instance;

    static synchronized WokabelDatabase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

    private static WokabelDatabase create(final Context context) {
        return Room.databaseBuilder(
                context,
                WokabelDatabase.class,
                DB_NAME).build();
    }

    public abstract VocableDao getVocableDao();

    public abstract SubgroupDao getSubgroupDao();

    public abstract SupergroupDao getSupergroupDao();
}