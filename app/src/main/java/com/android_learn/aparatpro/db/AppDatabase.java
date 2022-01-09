package com.android_learn.aparatpro.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.android_learn.aparatpro.model.Video;

@Database(entities = {Video.class}, version = 2, exportSchema = true)
public abstract class AppDatabase extends RoomDatabase {

    public abstract IDAO idao();

    public static AppDatabase instance = null;

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, AppDatabase.class, "video.db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }


}
