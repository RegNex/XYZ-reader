package com.example.xyzreader.ui;

import android.content.Context;
import android.util.AttributeSet;

public class CustomArticleImageView extends android.support.v7.widget.AppCompatImageView {
    public CustomArticleImageView(Context context) {
        super(context);
    }

    public CustomArticleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomArticleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //Unpack given dimens to new aspect ratio
        int threeTwoHeight = MeasureSpec.getSize(widthMeasureSpec) * 2 / 3;
        int threeTwoHeightSpec = MeasureSpec.makeMeasureSpec(threeTwoHeight, MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, threeTwoHeightSpec);
    }
}
