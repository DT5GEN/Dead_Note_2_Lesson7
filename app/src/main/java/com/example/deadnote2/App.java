package com.example.deadnote2;

import android.app.Application;

import com.example.deadnote2.data.SimpleNotesRepoImpl;
import com.example.deadnote2.domain.NotesRepo;

public class App extends Application {
    private static App sInstance = null;

    public final NotesRepo notesRepo = new SimpleNotesRepoImpl();
    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    public static App get () {
        return sInstance;
    }
}
