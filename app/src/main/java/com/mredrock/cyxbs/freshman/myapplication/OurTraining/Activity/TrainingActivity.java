package com.mredrock.cyxbs.freshman.myapplication.OurTraining.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import com.mredrock.cyxbs.freshman.myapplication.DataSecret.Adapter.MyFragmentPagerAdapter;
import com.mredrock.cyxbs.freshman.myapplication.InvisibleBar;
import com.mredrock.cyxbs.freshman.myapplication.OurTraining.Fragment.MessageFragment;
import com.mredrock.cyxbs.freshman.myapplication.OurTraining.Fragment.TipsFragment;
import com.mredrock.cyxbs.freshman.myapplication.OurTraining.IndicatorDrawable;
import com.mredrock.cyxbs.freshman.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.VISIBLE;

/**
 * 军训特辑界面
 */

public class TrainingActivity extends AppCompatActivity {

    private ImageView tipsBack;

    //设置ViewPager和TabLayout
    private ViewPager pager;
    private TabLayout tabLayout;
    //viewpager的数据源（fragment）
    private List<Fragment> fragList;
    //标题
    private List<String>titleList;
    //viewpager的两个子页面
    private MessageFragment messageFragment;
    private TipsFragment tipsFragment;
    private MyFragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.freshman_training_activity);
        //设置沉浸式状态栏
        InvisibleBar.initStatusBar(getWindow());
        init();
        initViewPager();
    }

    //初始化
    public void init(){
        //设置返回键
        tipsBack = findViewById(R.id.tips_back);
        tipsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        fragList = new ArrayList<>();
        titleList = new ArrayList<>();

        messageFragment = new MessageFragment();
        tipsFragment = new TipsFragment();

        //添加相关信息
        fragList.add(messageFragment);
        fragList.add(tipsFragment);

        titleList.add("军训风采");
        titleList.add("小贴士");

        //初始化ViewPager
        pager = findViewById(R.id.pager);
        //初始化TabLayout
        tabLayout = findViewById(R.id.tab);
        //创建PagerAdapter的适配器
        adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),fragList,titleList);
    }

    //设置viewpager的相关信息
    public void initViewPager(){

        //创建PagerAdapter的适配器
        adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),fragList,titleList);
        pager.setAdapter(adapter);
        //把标题加载到TabLayout中去
        tabLayout.addTab(tabLayout.newTab().setText(titleList.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(titleList.get(1)));
        //设置点击事件
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        tabLayout.setupWithViewPager(pager);
        //修改下划线长度
        reduceMarginsInTabs(tabLayout,100);
        //修改下划线样式
        View tabStripView = tabLayout.getChildAt(0);
        tabStripView.setBackground(new IndicatorDrawable(tabStripView));//设置背景 添加自定义下划线
        tabLayout.setVisibility(VISIBLE);
    }

    public static void reduceMarginsInTabs(TabLayout tabLayout, int marginOffset) {

        View tabStrip = tabLayout.getChildAt(0);
        if (tabStrip instanceof ViewGroup) {
            ViewGroup tabStripGroup = (ViewGroup) tabStrip;
            for (int i = 0; i < ((ViewGroup) tabStrip).getChildCount(); i++) {
                View tabView = tabStripGroup.getChildAt(i);
                if (tabView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) tabView.getLayoutParams()).leftMargin = marginOffset;
                    ((ViewGroup.MarginLayoutParams) tabView.getLayoutParams()).rightMargin = marginOffset;
                }
            }

            tabLayout.requestLayout();
        }
    }

}
