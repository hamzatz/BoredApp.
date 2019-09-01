package com.e.boredapp.intro;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

public class IntroPageConfig {

    @DrawableRes
    private  int imageRes;
    @StringRes
    private int  titleRes;

    public IntroPageConfig(int titleRes, int imageRes) {
        this.titleRes = titleRes;
        this.imageRes = imageRes;
    }

    public int getTitleRes() {
        return titleRes;
    }

    public int getImageRes() {
        return imageRes;
    }


}
