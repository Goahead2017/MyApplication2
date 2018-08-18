package com.mredrock.cyxbs.freshman.myapplication.DataSecret.Activity;

import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.mredrock.cyxbs.freshman.myapplication.DataSecret.Fragment.CourseFragment;
import com.mredrock.cyxbs.freshman.myapplication.DataSecret.Fragment.SexFragment;
import com.mredrock.cyxbs.freshman.myapplication.DataSecret.Adapter.MyFragmentPagerAdapter;
import com.mredrock.cyxbs.freshman.myapplication.InvisibleBar;
import com.mredrock.cyxbs.freshman.myapplication.OurTraining.IndicatorDrawable;
import com.mredrock.cyxbs.freshman.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.VISIBLE;

public class FindSecretActivity extends AppCompatActivity {

    //设置ViewPager和TabLayout
    private ViewPager pager;
    private TabLayout tabLayout;
    private List<Fragment>fragList;
    private List<String>titleList;
    private SexFragment sexFragment;
    private CourseFragment courseFragment;

    //获取传递过来的学院的名字
    private String schoolName;
    //设置返回键
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.freshman_find_serect);
        InvisibleBar.initStatusBar(getWindow());


        init();
        initViewPager();
        //获取传递过来的学院的名字
        schoolName = getIntent().getStringExtra("schoolName");
        sexFragment.getSchoolName(schoolName);
        courseFragment.getSchoolName(schoolName);
        Log.d("sex", "onCreate: " + schoolName);

    }

    private void initViewPager() {
        //创建PagerAdapter的适配器
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),fragList,titleList);
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
        reduceMarginsInTabs(tabLayout,100);
        View tabStripView = tabLayout.getChildAt(0);
        tabStripView.setBackground(new IndicatorDrawable(tabStripView));//设置背景 添加自定义下划线
        tabLayout.setVisibility(VISIBLE);
    }

    //初始化
    public void init(){
        fragList = new ArrayList<>();
        titleList = new ArrayList<>();

        sexFragment = new SexFragment();
        courseFragment = new CourseFragment();
        fragList.add(sexFragment);
        fragList.add(courseFragment);

        titleList.add("男女比例");
        titleList.add("最难科目");

        //初始化ViewPager
        pager = findViewById(R.id.pager);
        //初始化TabLayout
        tabLayout = findViewById(R.id.tab);

        //设置返回键
        back = findViewById(R.id.secret_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
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
