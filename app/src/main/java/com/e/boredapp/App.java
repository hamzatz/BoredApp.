package com.e.boredapp;

import android.app.Application;

import com.e.boredapp.utils.ISharedStorage;
import com.e.boredapp.utils.SharedStorage;

public class App extends Application {
    public  static ISharedStorage sharedStorage;

    @Override
    public void onCreate() {
        super.onCreate();
        sharedStorage= new SharedStorage(this, "prefs");
    }
}
