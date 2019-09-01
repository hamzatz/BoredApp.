package com.e.boredapp.intro;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.e.boredapp.R;
import com.e.boredapp.main.MainActivity;
import com.rd.PageIndicatorView;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {

    private IntroPageAdapter adapter;
    private ViewPager pager;
    Button bnext, bskip;
    PageIndicatorView pageIndicatorView;

    ArrayList<IntroPageConfig> pages = new ArrayList<>();



    public  static void start(Context context){
        Intent intent= new Intent(context, IntroActivity.class);
        context.startActivity(intent);
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);


       initViewPager();
            }
     private void initViewPager(){

         pages.add(new IntroPageConfig(R.string.app_name,R.drawable.group));
         pages.add(new IntroPageConfig(R.string.hello_blank_fragment,R.drawable.notestick));
         pages.add(new IntroPageConfig(R.string.hello_blank_fragment,R.drawable.notestick));

         adapter= new IntroPageAdapter(getSupportFragmentManager(),pages);
         pageIndicatorView= findViewById(R.id.pageIndicatorView);
         bnext=findViewById(R.id.buttonNext);
         bskip= findViewById(R.id.buttonSkip);
         pager= findViewById(R.id.viewPager);
         pager.setOffscreenPageLimit(3);
         pager.setAdapter(adapter);


         pager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener()
         {
             @Override
             public void onPageSelected(int position) {
                 onPageChange(position);
                 onPageSkip(position);
             }
         });

         pageIndicatorView.setViewPager(pager);


    }

    private void onPageSkip(int position) {
        String buttonFinish = "Skip";
        if (position==2){
            buttonFinish="";
        }
        bskip.setText(buttonFinish);
    }

    private void onPageChange(int position) {
        String buttonNext= "Next";
        if(position==2){
            buttonNext="Finish";

        }
       bnext.setText(buttonNext);
    }
private void onNextClick(){
        if(pager.getCurrentItem()==adapter.getCount()-1) {
            MainActivity.start(this);
            finish();
        }else {
            pager.setCurrentItem(pager.getCurrentItem()+1);
        }
    }
    public void OnClick(View view) {
        switch (view.getId()){
            case R.id.buttonNext:
                onNextClick();
                break;
            case R.id.buttonSkip:
                MainActivity.start(this);
                finish();
        }
    }

    public class IntroPageAdapter extends FragmentPagerAdapter{
        List<IntroPageConfig> pages;

        public IntroPageAdapter(
            FragmentManager fm, List<IntroPageConfig> pages){

            super(fm);
            this.pages= pages;
         }

         @Override
         public Fragment getItem(int position) {
             return IntroPageFragment.newInstance(pages.get(position));
         }

         @Override
         public int getCount() {
             return pages.size();
         }
     }





}
