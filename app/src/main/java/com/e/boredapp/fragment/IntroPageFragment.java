package com.e.boredapp.fragment;


import android.os.Bundle;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.e.boredapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class IntroPageFragment extends Fragment {

    private final static String ARG_TITLE_RES="title_res";
    private final static String ARG_IMAGE_RES="image_res";

    public IntroPageFragment() {
        // Required empty public constructor

    }
    public static IntroPageFragment newInstance(@StringRes int titleRes, @DrawableRes int imageRes){
        IntroPageFragment fragment =new IntroPageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_TITLE_RES,titleRes);
        args.putInt(ARG_IMAGE_RES,imageRes);
        fragment.setArguments(args);
        return fragment;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_intro_page, container, false);

        return view;
    }

}
