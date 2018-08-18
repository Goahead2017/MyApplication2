package com.mredrock.cyxbs.freshman.myapplication.DataSecret.DIYView;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.mredrock.cyxbs.freshman.myapplication.R;

public class SexDrawView extends View{

    private ValueAnimator anim1;
    private ValueAnimator anim2;
    private float currentValue1;
    private float currentValue2;
    private Paint paint1;
    private Paint paint11;
    private Paint paint2;
    private Paint paint3;

    private Paint paint4;
    private Paint paint44;
    private Paint paint5;
    private Paint paint6;

    Path path1;
    Path path2;

    int totalNum;

    public SexDrawView(Context context) {
        this(context,null);
    }

    public SexDrawView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SexDrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context,attrs,defStyleAttr);
        init();
    }

    @SuppressLint("ResourceAsColor")
    private void init() {
        paint1 = new Paint();
        paint1.setColor(getResources().getColor(R.color.blue_miaobian));
        paint1.setStrokeWidth(5);
        paint1.setAlpha(70);
        paint1.setDither(true);
        paint1.setAntiAlias(true);
        paint1.setStyle(Paint.Style.STROKE);
        paint11 = new Paint();
        paint11.setColor(getResources().getColor(R.color.blue_miaobian));
        paint11.setStrokeWidth(45);
        paint11.setAlpha(60);
        paint11.setDither(true);
        paint11.setAntiAlias(true);
        paint11.setStyle(Paint.Style.STROKE);

        paint2 = new Paint();
        paint2.setColor(getResources().getColor(R.color.blue_miaobian2));
        paint2.setStrokeWidth(45);
        paint2.setAlpha(60);
        paint2.setDither(true);
        paint2.setAntiAlias(true);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        paint2.setStyle(Paint.Style.STROKE);

        paint3 = new Paint();
        paint3.setTextSize(35);
        paint3.setColor(getResources().getColor(R.color.blue_text));

        paint4 = new Paint();
        paint4.setColor(getResources().getColor(R.color.pink_miaobian));
        paint4.setStrokeWidth(5);
        paint4.setAlpha(80);
        paint4.setDither(true);
        paint4.setAntiAlias(true);
        paint4.setStyle(Paint.Style.STROKE);
        paint44 = new Paint();
        paint44.setColor(getResources().getColor(R.color.pink_miaobian));
        paint44.setStrokeWidth(45);
        paint44.setAlpha(60);
        paint44.setDither(true);
        paint44.setAntiAlias(true);
        paint44.setStyle(Paint.Style.STROKE);

        paint5 = new Paint();
        paint5.setColor(getResources().getColor(R.color.pink_miaobian2));
        paint5.setStrokeWidth(45);
        paint5.setAlpha(60);
        paint5.setDither(true);
        paint5.setAntiAlias(true);
        paint5.setStrokeCap(Paint.Cap.ROUND);
        paint5.setStyle(Paint.Style.STROKE);

        paint6 = new Paint();
        paint6.setTextSize(35);
        paint6.setColor(getResources().getColor(R.color.pink_text));

        anim1 = ValueAnimator.ofFloat(0,260);
        anim2 = ValueAnimator.ofFloat(0,200);
        path1 = new Path();
        path2 = new Path();

    }

    @SuppressLint({"DefaultLocale", "DrawAllocation"})
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //设置padding属性
        final float paddingLeft = getPaddingLeft();
        final float paddingRight = getPaddingRight();
        final float paddingTop = getPaddingTop();
        final float paddingBottom = getPaddingBottom();

        //获取父布局的宽和高
        float width = getWidth();
        float height = getHeight();

        //测量所绘制圆形的宽、高和半径
        float circleWidth1 = width - paddingLeft - paddingRight;
        float circleHeight1 = height - paddingTop - paddingBottom;
        float r1 = Math.min(circleWidth1, circleHeight1) / 2 - 99 - 70;

        float circleWidth2 = width - paddingLeft - paddingRight - 60;
        float circleHeight2 = height - paddingTop - paddingBottom - 60;
        float r2 = Math.min(circleWidth2, circleHeight2) / 2 - 119 - 70;

        //第一个圆环的半径
        float r3 = r1/2 + r2/2;

        float circleWidth3 = width - paddingLeft - paddingRight - 80;
        float circleHeight3 = height - paddingTop - paddingBottom - 80;
        float r4 = Math.min(circleWidth3, circleHeight3) / 2 - 159 - 80;

        float circleWidth4 = width - paddingLeft - paddingRight - 140;
        float circleHeight4 = height - paddingTop - paddingBottom - 140;
        float r5 = Math.min(circleWidth4, circleHeight4) / 2 - 179 - 80;

        //第二个圆环的半径
        float r6 = r4/2 + r5/2;

        //绘制外面的圆形
        canvas.drawCircle(width/2,height/2 - 160, r1,paint1);
        canvas.drawCircle(width/2,height/2 - 160, r2,paint1);
        //绘制里面的圆形
        @SuppressLint("DrawAllocation") RectF oval3 = new RectF(paddingLeft + r1 - r3 + 99 + 70,height/2 - 100 - r3 - 60,paddingLeft + r1 + r3 + 99 + 70,height/2 - 100 + r3 - 60);
        canvas.drawArc(oval3,-90,360,false,paint11);

        //绘制外面的圆形
        canvas.drawCircle(width/2,height/2 - 160, r4,paint4);
        canvas.drawCircle(width/2,height/2 - 160, r5,paint4);
        //绘制里面的圆形
        @SuppressLint("DrawAllocation") RectF oval4 = new RectF(paddingLeft + r1 - r2 + 10 + r4 - r6 + 139 + 80,height/2 - 100 - r6 - 60,paddingLeft + r1 + r6 + 99 + 70,height/2 - 100 + r6 - 60);
        canvas.drawArc(oval4,-90,360,false,paint44);

        if(totalNum != 0) {

            //绘制里面的圆形
            @SuppressLint("DrawAllocation") RectF oval1 = new RectF(paddingLeft + r1 - r3 + 99 + 70, height / 2 - 100 - r3 - 60, paddingLeft + r1 + r3 + 99 + 70, height / 2 - 100 + r3 - 60);
            @SuppressLint("DrawAllocation") RectF oval2 = new RectF(paddingLeft + r1 - r2 + 10 + r4 - r6 + 139 + 80, height / 2 - 100 - r6 - 60, paddingLeft + r1 + r6 + 99 + 70, height / 2 - 100 + r6 - 60);
            canvas.drawArc(oval1, -90, 0 + currentValue1 / totalNum * 360, false, paint2);
            canvas.drawArc(oval2, -90, 0 + currentValue2 / totalNum * 360, false, paint5);

            canvas.drawText(String.format("%.0f", currentValue1 / totalNum * 100) + "%", width / 2 - 10 - 80, height / 2 - 100 - r3 - r1 + r3 - 20, paint3);
            canvas.drawText(String.format("%.0f", currentValue2 / totalNum * 100) + "%", paddingLeft + r1 + 80, height / 2 - r1 - 10, paint6);
        }

    }

    public void getSex(int male_amount,int female_amount) {
        totalNum = male_amount + female_amount;
        Log.d("sexDraw", "getSex: " + male_amount + "," +  female_amount + "," + totalNum);
        invalidate();
        anim1 = ValueAnimator.ofFloat(0,male_amount);
        anim2 = ValueAnimator.ofFloat(0,female_amount);

        anim1.setDuration(3000);
        anim1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentValue1 = (Float)animation.getAnimatedValue();
                invalidate();
            }
        });
        anim1.start();

        anim2.setDuration(3000);
        anim2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentValue2 = (Float)animation.getAnimatedValue();
                invalidate();
            }
        });
        anim2.start();
    }

}
