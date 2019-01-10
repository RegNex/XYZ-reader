package com.example.xyzreader.utils;

import android.content.Context;
import android.graphics.Color;
import android.view.View;

import com.example.xyzreader.R;

public class ColorPalette {

    private int mMutedColor = 0xFF333333;
    private int mTopInset;
    private int mScrollY;
    private int mStatusBarFullOpacityBottom;

    ColorPalette(Context context) {
        mStatusBarFullOpacityBottom = context.getResources().getDimensionPixelSize(
                R.dimen.detail_card_top_margin);
    }

    private void updateStatusBar(View view) {
        int color = 0;
        if (view != null && mTopInset != 0 && mScrollY > 0) {
            float f = progress(mScrollY,
                    mStatusBarFullOpacityBottom - mTopInset * 3,
                    mStatusBarFullOpacityBottom - mTopInset);
            color = Color.argb((int) (255 * f),
                    (int) (Color.red(mMutedColor) * 0.9),
                    (int) (Color.green(mMutedColor) * 0.9),
                    (int) (Color.blue(mMutedColor) * 0.9));
        }
//        getWindow().setStatusBarColor(ColorUtils.manipulateColor(mPaletteColor, 0.32f));


    }

    private static float progress(float v, float min, float max) {
        return constrain((v - min) / (max - min), 0, 1);
    }

    private static float constrain(float val, float min, float max) {
        if (val < min) {
            return min;
        } else if (val > max) {
            return max;
        } else {
            return val;
        }
    }
}
