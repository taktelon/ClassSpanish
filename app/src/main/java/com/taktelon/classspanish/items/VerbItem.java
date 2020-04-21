package com.taktelon.classspanish.items;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "verbs")
public class VerbItem {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private final int mId;
    @ColumnInfo(name = "verb")
    private final String mVerb;
    @ColumnInfo(name = "meaning")
    private final String mMeaning;

    public VerbItem(int id, String verb, String meaning) {
        mId = id;
        mVerb = verb;
        mMeaning = meaning;
    }

    public int getId() {
        return mId;
    }

    public String getVerb() {
        return mVerb;
    }

    public String getMeaning() {
        return mMeaning;
    }
}
