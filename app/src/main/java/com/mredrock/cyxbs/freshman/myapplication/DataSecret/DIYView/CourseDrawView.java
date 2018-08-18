package com.mredrock.cyxbs.freshman.myapplication.DataSecret.DIYView;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.mredrock.cyxbs.freshman.myapplication.DataSecret.Bean.CourseDataBean;
import com.mredrock.cyxbs.freshman.myapplication.R;


public class CourseDrawView extends View {

    private Paint xyPaint;
    private Path xyPath;
    private Paint tPaint;
    private Paint paint1;
    private Paint paint2;
    private Paint paint3;
    private Paint paint;
    private Paint dPaint;

    private ValueAnimator anim1;
    private ValueAnimator anim2;
    private ValueAnimator anim3;
    private float currentValue1;
    private float currentValue2;
    private float currentValue3;
    private CourseDataBean courseDataBean;

    public CourseDrawView(Context context) {
        this(context,null);
    }

    public CourseDrawView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CourseDrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    private void init() {
        xyPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        xyPaint.setColor(getResources().getColor(R.color.dash_line));
        xyPaint.setStyle(Paint.Style.STROKE);
        xyPaint.setStrokeWidth(1);
        xyPaint.setPathEffect(new DashPathEffect(new float[] {5, 5}, 0));
        xyPath = new Path();

        tPaint = new Paint();
        tPaint.setColor(getResources().getColor(R.color.blue_num));
        tPaint.setTextSize(35);

        paint = new Paint();
        paint.setColor(getResources().getColor(R.color.people));
        paint.setTextSize(35);
        dPaint = new Paint();
        dPaint.setColor(getResources().getColor(R.color.down_text));
        dPaint .setTextSize(30);



        paint1 = new Paint();
        paint1.setColor(getResources().getColor(R.color.rect_one));
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setStrokeWidth(80);
        paint1.setDither(true);
        paint1.setAntiAlias(true);

        paint2 = new Paint();
        paint2.setColor(getResources().getColor(R.color.rect_two));
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(80);
        paint2.setDither(true);
        paint2.setAntiAlias(true);

        paint3 = new Paint();
        paint3.setColor(getResources().getColor(R.color.rect_three));
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeWidth(80);
        paint3.setDither(true);
        paint3.setAntiAlias(true);
    }


    @SuppressLint("DefaultLocale")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float lenX = getWidth() - 107 - 147;
        float lenY = 420;
        xyPath.reset();
        xyPath.moveTo(147, 200);
        xyPath.lineTo(getWidth() - 107, 200);
        canvas.drawPath(xyPath, xyPaint);
        canvas.drawText(120 + "",87,210,tPaint);

        xyPath.reset();
        xyPath.moveTo(147, 270);
        xyPath.lineTo(getWidth() - 107, 270);
        canvas.drawPath(xyPath, xyPaint);
        canvas.drawText(100 + "",87,280,tPaint);

        xyPath.reset();
        xyPath.moveTo(147, 340);
        xyPath.lineTo(getWidth() - 107, 340);
        canvas.drawPath(xyPath, xyPaint);
        canvas.drawText(" " + 80 + "",87,350,tPaint);

        xyPath.reset();
        xyPath.moveTo(147, 410);
        xyPath.lineTo(getWidth() - 107, 410);
        canvas.drawPath(xyPath, xyPaint);
        canvas.drawText(" " + 60 + "",87,420,tPaint);

        xyPath.reset();
        xyPath.moveTo(147, 480);
        xyPath.lineTo(getWidth() - 107, 480);
        canvas.drawPath(xyPath, xyPaint);
        canvas.drawText(" " + 40 + "",87,490,tPaint);

        xyPath.reset();
        xyPath.moveTo(147, 550);
        xyPath.lineTo(getWidth() - 107, 550);
        canvas.drawPath(xyPath, xyPaint);
        canvas.drawText(" " + 20 + "",87,560,tPaint);

        xyPath.reset();
        xyPath.moveTo(147, 620);
        xyPath.lineTo(getWidth() - 107, 620);
        canvas.drawPath(xyPath, xyPaint);
        canvas.drawText(" " + " " + 0 + "",87,630,tPaint);

        //绘制矩形条
        if(courseDataBean != null) {
            if(currentValue1 <= 120) {
                canvas.drawLine(147 + lenX / 6, 620, 147 + lenX / 6, 620 - currentValue1 / 120 * lenY, paint1);
                if (currentValue1 == courseDataBean.getArray().get(0).getBelow_amount() || currentValue1 == 120) {
                    canvas.drawText(String.format("%.0f", currentValue1) + "人", 107 + lenX / 6, 620 - currentValue1 * lenY / 120 - 20, paint);
                }
            }else {
                canvas.drawLine(147 + lenX / 6, 620, 147 + lenX / 6, 620 - 120 / 120 * lenY, paint1);
                canvas.drawText(String.format("%.0f", currentValue1) + "人", 107 + lenX / 6, 620 - 120 * lenY / 120 - 20, paint);
            }
            String str1 = courseDataBean.getArray().get(0).getSubject_name();
            if(str1.length() > 5) {
                String str11 = str1.substring(0,5);
                String str12 = str1.substring(5);
                canvas.drawText(str11, 87 + lenX / 6, 620 + 40, dPaint);
                canvas.drawText(str12, 87 + lenX / 6, 620 + 80, dPaint);
            }else {
                canvas.drawText(str1, 87 + lenX / 6, 620 + 40, dPaint);
            }

            if(currentValue2 <= 120) {
                canvas.drawLine(147 + lenX * 3 / 6, 620, 147 + lenX * 3 / 6, 620 - currentValue2 * lenY / 120, paint2);
                if (currentValue2 == courseDataBean.getArray().get(1).getBelow_amount() || currentValue2 == 120) {
                    canvas.drawText(String.format("%.0f", currentValue2) + "人", 107 + lenX * 3 / 6, 620 - currentValue2 * lenY / 120 - 20, paint);
                }
            }else {
                canvas.drawLine(147 + lenX * 3 / 6, 620, 147 + lenX * 3 / 6, 620 - 120 * lenY / 120, paint2);
                canvas.drawText(String.format("%.0f", currentValue2) + "人", 107 + lenX * 3 / 6, 620 - 120 * lenY / 120 - 20, paint);
            }
            String str2 = courseDataBean.getArray().get(1).getSubject_name();
            if(str2.length() > 5) {
                String str21 = str1.substring(0,5);
                String str22 = str1.substring(5);
                canvas.drawText(str21, 87 + lenX * 3 / 6, 620 + 40, dPaint);
                canvas.drawText(str22, 87 + lenX * 3 / 6, 620 + 80, dPaint);
            }else {
                canvas.drawText(str2, 87 + lenX * 3 / 6, 620 + 40, dPaint);
            }

            if(currentValue3 <= 120) {
                canvas.drawLine(147 + lenX * 5 / 6, 620, 147 + lenX * 5 / 6, 620 - currentValue3 * lenY / 120, paint3);
                if (currentValue3 == courseDataBean.getArray().get(2).getBelow_amount() || currentValue3 == 120) {
                    canvas.drawText(String.format("%.0f", currentValue3) + "人", 107 + lenX * 5 / 6, 620 - currentValue3 * lenY / 120 - 20, paint);
                }
            }else {
                canvas.drawLine(147 + lenX * 5 / 6, 620, 147 + lenX * 5 / 6, 620 - 120 * lenY / 120, paint3);
                canvas.drawText(String.format("%.0f", currentValue3) + "人", 107 + lenX * 5 / 6, 620 - 120 * lenY / 120 - 20, paint);
            }
            String str3 = courseDataBean.getArray().get(2).getSubject_name();
            if(str3.length() > 5) {
                String str31 = str1.substring(0,5);
                String str32 = str1.substring(5);
                canvas.drawText(str31, 87 + lenX * 5 / 6, 620 + 40, dPaint);
                canvas.drawText(str32, 87 + lenX * 5 / 6, 620 + 80, dPaint);
            }else {
                canvas.drawText(str3, 87 + lenX * 5 / 6, 620 + 40, dPaint);
            }
        }
    }

    public void getData(CourseDataBean courseDataBean) {
        this.courseDataBean = courseDataBean;
        anim1 = ValueAnimator.ofFloat(0,courseDataBean.getArray().get(0).getBelow_amount());
        anim2 = ValueAnimator.ofFloat(0,courseDataBean.getArray().get(1).getBelow_amount());
        anim3 = ValueAnimator.ofFloat(0,courseDataBean.getArray().get(2).getBelow_amount());
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
        anim3.setDuration(3000);
        anim3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentValue3 = (Float)animation.getAnimatedValue();
                invalidate();
            }
        });
        anim3.start();
    }
}
