package com.taktelon.classspanish.items;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import java.util.List;

public class VerbRepository {
    private String DB_NAME = "spanish_lesson";
    private VerbDatabase verbDatabase;

    public VerbRepository(Context context){
        verbDatabase = Room.databaseBuilder(context, VerbDatabase.class, DB_NAME).build();
    }

    public void insertVerb(int id, String verb, String meaning){
        VerbItem verbItem = new VerbItem(id, verb, meaning);
        insertVerb(verbItem);
    }

    public void insertVerb(final VerbItem verbItem){
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                verbDatabase.verbDao().insertVerb(verbItem);
                return null;
            }
        }.execute();
    }

    public LiveData<List<VerbItem>> getAllVerbs(){
        return verbDatabase.verbDao().getAllVerbs();
    }

    public List<VerbItem> getVerbs(){
        return verbDatabase.verbDao().getVerbs();
    }
}
