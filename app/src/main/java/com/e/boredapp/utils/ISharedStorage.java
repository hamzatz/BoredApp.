package com.e.boredapp.utils;

public interface ISharedStorage {
    void setBoolean(String key,boolean value);
    boolean getBoolean(String key, boolean defValue);

}
