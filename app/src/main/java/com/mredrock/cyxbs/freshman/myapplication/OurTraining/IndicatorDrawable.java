package com.mredrock.cyxbs.freshman.myapplication.OurTraining;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.mredrock.cyxbs.freshman.myapplication.R;

import java.lang.reflect.Field;

/**
 * 自定义tablayout下滑条
 */

public class IndicatorDrawable extends Drawable {
    private static final int INDICATOR_MARGIN = 4;
    private static final int INDICATOR_HEIGHT = 3;
    private static final int INDICATOR_RADIUS = 20;

    private View view;
    private Paint paint;

    public IndicatorDrawable(View view) {
        this.view = view;
        this.paint = new Paint();
        paint.setColor(view.getContext().getResources().getColor(R.color.view));
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        int mIndicatorLeft = getIntValue("mIndicatorLeft");
        int mIndicatorRight = getIntValue("mIndicatorRight");
        int radius = INDICATOR_RADIUS;
        if (mIndicatorLeft >= 0 && mIndicatorRight > mIndicatorLeft) {
            canvas.drawRoundRect(new RectF(mIndicatorLeft + INDICATOR_MARGIN, view.getHeight() - INDICATOR_HEIGHT, mIndicatorRight - INDICATOR_MARGIN, view.getHeight()), radius, radius, paint);
        }
    }

    private int getIntValue(String name) {
        try {
            Field f = view.getClass().getDeclaredField(name);
            f.setAccessible(true);
            Object obj = f.get(view);
            return (Integer) obj;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public void setAlpha(@IntRange(from = 0, to = 255) int alpha) {

    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.UNKNOWN;
    }
}