package com.taktelon.classspanish.items;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface VerbDao {
    @Query("SELECT * FROM verbs ORDER BY verb DESC")
    LiveData<List<VerbItem>> getAllVerbs();

    @Query("SELECT * FROM verbs ORDER BY verb DESC")
    List<VerbItem> getVerbs();

    @Query("SELECT * FROM verbs WHERE id =:id")
    VerbItem getVerb(int id);

    @Insert
    void insertVerb(VerbItem verb);

    @Delete
    void deleteVerb(VerbItem verb);
}
