package com.e.boredapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedStorage implements ISharedStorage {

    private SharedPreferences preferences;

    public SharedStorage(Context context, String prefName){
        preferences=context.getSharedPreferences(prefName,Context.MODE_PRIVATE);

    }

    @Override
    public <T> void set(String key, T value) {
        if(value instanceof Integer){
            preferences.edit().putInt(key,(Integer) value).apply();
        }else if (value instanceof String){
            preferences.edit().putString(key,(String) value).apply();
        }else if (value instanceof Boolean){
            preferences.edit().putBoolean(key,(Boolean) value).apply();
        }else {}
    }

    @Override
    public <T> T get(String key, T defValue) {
        if (defValue instanceof Integer) {
            return (T) Integer.valueOf(preferences.getInt(key, (Integer) defValue));
        } else if (defValue instanceof String) {
            return (T) String.valueOf(preferences.getString(key, (String) defValue));
        } else if (defValue instanceof Boolean) {
            return (T) Boolean.valueOf(preferences.getBoolean(key, (Boolean) defValue));
        } else {
            return null;
        }

    }
}
