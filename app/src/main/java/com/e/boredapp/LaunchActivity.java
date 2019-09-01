package com.e.boredapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.e.boredapp.intro.IntroActivity;
import com.e.boredapp.main.MainActivity;

public class LaunchActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

          redirect();
    }
    public void redirect (){

        if(App.appPreferences.isFirstLaunch()){
            Log.e("-------", "true");
            App.appPreferences.setLaunched();
            IntroActivity.start(this);

        }else {
            MainActivity.start(this);
        }
        finish();
    }
    }

