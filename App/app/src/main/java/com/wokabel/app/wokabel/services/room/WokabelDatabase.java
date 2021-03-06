package com.wokabel.app.wokabel.services.room;


import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import com.wokabel.app.wokabel.models.Subgroup;
import com.wokabel.app.wokabel.models.Supergroup;
import com.wokabel.app.wokabel.models.Vocable;

@Database(entities = {Vocable.class, Subgroup.class, Supergroup.class}, version = 1, exportSchema = false)
@TypeConverters(Typeconverter.class)
public abstract class WokabelDatabase extends RoomDatabase {

    private static final String DB_NAME = "wokabelDatabase.db";
    private static volatile WokabelDatabase instance;

    public static WokabelDatabase create(final Context context) {

        if(instance == null){
            synchronized (WokabelDatabase.class){
                if(instance == null){
                    instance = Room.databaseBuilder(context.getApplicationContext(), WokabelDatabase.class, DB_NAME)
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                    //new LoadData(instance).execute();
                }
            }
        }
        return instance;
    }

    public abstract VocableDao getVocableDao();

    public abstract SubgroupDao getSubgroupDao();

    public abstract SupergroupDao getSupergroupDao();

    private static class LoadData extends AsyncTask<Void, Void, Void> {

        private final WokabelDatabase mDb;

        LoadData(WokabelDatabase db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            //load data if necessary
            //mDb.getSupergroupDao().insert(new Supergroup("Test 1", "null") );
            //mDb.getSupergroupDao().insert(new Supergroup("Test 2", "null"));
            Log.d("Database","loading data");
            return null;
        }
    }
    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new LoadData(instance).execute();
                }
            };
}