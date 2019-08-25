package com.e.boredapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class LaunchActivity extends AppCompatActivity {
    private static final String PREF_KEY = "is_first_launch";

    public  static void start(Context context){
        Intent intent= new Intent(context, LaunchActivity.class);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        SharedPreferences sharedPreferences= getSharedPreferences("prefs", Context.MODE_PRIVATE);
        boolean isFirstLaunch= sharedPreferences.getBoolean(PREF_KEY,true);
        Intent intent;
        if(isFirstLaunch){
            sharedPreferences.edit().putBoolean(PREF_KEY,false).apply();
            intent= new Intent(this, IntroActivity.class);

        }else {
            intent= new Intent(this, MainActivity.class);

        }
        startActivity(intent);
        finish();

    }
    }

