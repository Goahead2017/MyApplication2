package com.mredrock.cyxbs.freshman.myapplication.OurTraining;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import com.mredrock.cyxbs.freshman.myapplication.R;

import java.util.List;

/**
 * 军训风采军训图片轮播图
 */

public class BannerView2 extends RelativeLayout {

    private ViewPager mViewPager;


    public BannerView2(Context context) {
        super(context);
        initBanner();
    }

    public BannerView2(Context context, AttributeSet attrs) {
        super(context, attrs);
        initBanner();
    }

    private void initBanner() {
        this.setClipChildren(false);
    }

    public BannerView2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initBanner();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mViewPager = findViewById(R.id.fragment_recommend_viewPager2);
    }


    @SuppressLint("ClickableViewAccessibility")
    public void show(FragmentManager fragmentManager, List<Fragment> fragList) {

        if (fragList == null || fragList.size() == 0) {
            return;
        }

        //重置数据
        if (mViewPager.getChildCount() > 0) {
            mViewPager.removeAllViews();
        }

        //clipChild用来定义他的子控件是否要在他应有的边界内进行绘制。 默认情况下，clipChild被设置为true。 也就是不允许进行扩展绘制。
        mViewPager.setClipChildren(false);
        mViewPager.setAdapter(new BannerAdapter(fragmentManager, fragList,1));
        mViewPager.setOffscreenPageLimit(3);

        //设置第一个显示的页面
        int currentItem = Integer.MIN_VALUE / 2;
        mViewPager.setCurrentItem(currentItem);

        //设置ViewPager切换效果，即实现画廊效果
        mViewPager.setPageTransformer(false, new GalleryTransformer());


        //将容器的触摸事件反馈给ViewPager
        this.setOnTouchListener(new OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return mViewPager.dispatchTouchEvent(event);
            }

        });

    }
}