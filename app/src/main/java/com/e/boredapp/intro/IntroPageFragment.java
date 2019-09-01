package com.e.boredapp.intro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.e.boredapp.R;

public class IntroPageFragment extends Fragment {
    private final static String ARG_TITLE_RES = "title_res";
    private final static String ARG_IMAGE_RES = "image_res";

    public static  Fragment newInstance(IntroPageConfig config) {
      Fragment fragment= new Fragment();
      Bundle args = new Bundle();
      args.putInt(ARG_TITLE_RES,config.getTitleRes());
      args.putInt(ARG_IMAGE_RES,config.getImageRes());
      fragment.setArguments(args);
      return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_intro_page, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView=view.findViewById(R.id.text_intro);
        textView.setText(getArguments().getInt(ARG_TITLE_RES));
        ImageView imageView= view.findViewById(R.id.imageView);
        imageView.setImageResource(getArguments().getInt(ARG_IMAGE_RES));
    }
}
