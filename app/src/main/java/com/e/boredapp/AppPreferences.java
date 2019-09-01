package com.e.boredapp;

import com.e.boredapp.utils.ISharedStorage;

public class AppPreferences {
    private static final String PREF_KEY = "is_first_launch";
    private ISharedStorage sharedStorage;
    public  AppPreferences(ISharedStorage sharedStorage){
        this.sharedStorage=sharedStorage;
    }

    boolean isFirstLaunch(){
        return sharedStorage.get(PREF_KEY,true);
    }
    void  setLaunched(){
        sharedStorage.set(PREF_KEY,false);

    }
}
