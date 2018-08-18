package com.mredrock.cyxbs.freshman.myapplication.OurTraining;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * 军训风采军训视频的轮播效果实现
 */

public class ZoomPageTransformer implements ViewPager.PageTransformer {
    private static final float MAX_SCALE = 1.0f;

    private static final float MIN_SCALE = 0.85f;//0.85f

    private static final  float MIN_ALPHA = 0.3f;

    private static final String TAG = "PageTransformer";
    @Override
    public void transformPage(View view, float position) {
        //setScaleY只支持api11以上
        if (position < -1) {
            view.setScaleX(MIN_SCALE);
            view.setScaleY(MIN_SCALE);
            view.setAlpha(MIN_ALPHA);//左边的左边的Page
        } else if (position <= 1) {
            float scaleFactor = MIN_SCALE + (1 - Math.abs(position)) * (MAX_SCALE - MIN_SCALE);
            if (position > 0) {
                view.setTranslationX(scaleFactor);
            } else if (position < 0) {
                view.setTranslationX(scaleFactor);
            }
            view.setScaleY(scaleFactor);
            view.setScaleX(scaleFactor);

           // float alpha = 1f -  Math.abs(position) * (1 - );

            float alpha = MIN_ALPHA + (1 - MIN_ALPHA) * (1 - Math.abs(position));
            view.setAlpha(alpha);

            Log.i(TAG,"position = " + position + " alpha = " + alpha);

        } else { // (1,+Infinity]

            view.setScaleX(MIN_SCALE);
            view.setScaleY(MIN_SCALE);
            view.setAlpha(MIN_ALPHA);
        }
    }
}
