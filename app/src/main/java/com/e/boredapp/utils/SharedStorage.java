package com.e.boredapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedStorage implements ISharedStorage {

    private SharedPreferences preferences;

    public SharedStorage(Context context, String prefName){
        preferences=context.getSharedPreferences(prefName,Context.MODE_PRIVATE);

    }

    @Override
    public void setBoolean(String key, boolean value) {
        preferences.edit().putBoolean(key,value).apply();
    }

    @Override
    public boolean getBoolean(String key, boolean defValue) {
        return preferences.getBoolean(key,defValue);
    }
}
