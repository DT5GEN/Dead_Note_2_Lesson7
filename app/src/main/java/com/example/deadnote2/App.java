package com.example.deadnote2;

import android.app.Application;

import com.example.deadnote2.data.SimpleColorsRepoImpl;
import com.example.deadnote2.domain.ColorsRepo;

public class App extends Application {
    private static App sInstance = null;

    public final ColorsRepo colorsRepo = new SimpleColorsRepoImpl();
    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    public static App get () {
        return sInstance;
    }
}
