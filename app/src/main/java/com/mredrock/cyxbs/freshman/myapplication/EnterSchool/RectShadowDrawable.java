package com.mredrock.cyxbs.freshman.myapplication.EnterSchool;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import static java.lang.Math.abs;

/**
 * 一个能绘制圆角矩形（圆角能内凹）并自带阴影的Drawable（可设置阴影颜色）
 *
 * Created By jay68 on 2018/5/4.
 */
public class RectShadowDrawable extends Drawable {
    private Rect mRadius;
    private int mShadowRadius;
    private int mOffsetX, mOffsetY;
    private boolean[] mHideShadow;

    private Paint mPaint;
    private Path mShape;
    private RectF mRectF;

    private View mView;

    public RectShadowDrawable(Rect radius, @ColorInt int backgroundColor, @ColorInt int shadowColor,
                              int shadowRadius, int offsetX, int offsetY) {
        this(radius, backgroundColor, shadowColor, shadowRadius, offsetX, offsetY, new boolean[]{false, false, false, false}, null);
    }

    public RectShadowDrawable(Rect radius, @ColorInt int backgroundColor, @ColorInt int shadowColor,
                              int shadowRadius, int offsetX, int offsetY, boolean hideShadow[], View view) {
        mRadius = radius;
        mShadowRadius = shadowRadius;
        mOffsetX = offsetX;
        mOffsetY = offsetY;
        mHideShadow = hideShadow;

        mPaint = new Paint();
        mPaint.setColor(backgroundColor);
        mPaint.setAntiAlias(true);
        mPaint.setShadowLayer(shadowRadius, offsetX, offsetY, shadowColor);

        mShape = new Path();
        mView = view;
//        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
    }

    @Override
    public void setBounds(int left, int top, int right, int bottom) {
        super.setBounds(left, top, right, bottom);
        mRectF = new RectF(left - mOffsetX, top - mOffsetY, right - mOffsetX, bottom - mOffsetY);
        mRectF.left += (mHideShadow != null && mHideShadow[0]) ? 0 : mShadowRadius;
        mRectF.top += (mHideShadow != null && mHideShadow[1]) ? 0 : mShadowRadius;
        mRectF.right -= (mHideShadow != null && mHideShadow[2]) ? 0 : mShadowRadius;
        mRectF.bottom -= (mHideShadow != null && mHideShadow[3]) ? 0 : mShadowRadius;
        resetShape(mRectF);
    }

    private void resetShape(RectF rectF) {
        mShape.reset();
        //todo 太丑了，做完再优化吧
        mShape.moveTo(rectF.left, rectF.top + abs(mRadius.left));
        mShape.lineTo(rectF.left, rectF.bottom - abs(mRadius.bottom));
        mShape.close();
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        canvas.drawPath(mShape, mPaint);
    }

    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}