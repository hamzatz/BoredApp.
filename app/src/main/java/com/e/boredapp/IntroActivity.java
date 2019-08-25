package com.e.boredapp;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.e.boredapp.fragment.IntroPageFragment;

public class IntroActivity extends AppCompatActivity {

    private SectionPagerAdapter adapter;
    private ViewPager pager;
    private Button button;


    public  static void start(Context context){
        Intent intent= new Intent(context, IntroActivity.class);
        context.startActivity(intent);
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        pager=findViewById(R.id.viewPager);
        button = findViewById(R.id.buttonSkip);

        adapter= new SectionPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);

    }

    public void OnClick(View view) {
        MainActivity.start(this);
    }

    public class SectionPagerAdapter extends FragmentStatePagerAdapter {

        public SectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }
              int titleRes = R.string.app_name;
              int imageRes =R.drawable.group;

        @Override
        public Fragment getItem(int position) {

            return IntroPageFragment.newInstance(titleRes, imageRes);
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
