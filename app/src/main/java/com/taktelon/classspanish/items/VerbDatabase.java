package com.taktelon.classspanish.items;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {VerbItem.class}, version = 1)
public abstract class VerbDatabase extends RoomDatabase {
    public abstract VerbDao verbDao();
}
