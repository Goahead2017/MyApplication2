package com.mredrock.cyxbs.freshman.myapplication.OurTraining.Activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.mredrock.cyxbs.freshman.myapplication.DataSecret.Adapter.MyFragmentPagerAdapter;
import com.mredrock.cyxbs.freshman.myapplication.InvisibleBar;
import com.mredrock.cyxbs.freshman.myapplication.OurTraining.Bean.TrainDataBean;
import com.mredrock.cyxbs.freshman.myapplication.OurTraining.Fragment.WatchPicFragment;
import com.mredrock.cyxbs.freshman.myapplication.OurTraining.TrainingPresenter;
import com.mredrock.cyxbs.freshman.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 点击图片放大的界面
 */

public class WatchPictureActivity extends AppCompatActivity {

    private ViewPager pager;
    private List<Fragment> fragList;
    private MyFragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.freshman_watch_picture);
        //设置沉浸式状态栏
        InvisibleBar.initStatusBar(getWindow());
        new TrainingPresenter(this);
        init();

    }

    //初始化
    public void init(){
        fragList = new ArrayList<>();
        pager = findViewById(R.id.pager);

    }

    //设置viewpager
    public void initViewPager(){
        pager.setAdapter(adapter);
    }

    private void getData() {
        //接收数据
        Intent intent = getIntent();
        String pos = intent.getStringExtra("pos");
        pager.setCurrentItem(Integer.parseInt(pos));
    }

    public void getBean(TrainDataBean trainDataBean) {
        for(int i=0;i<trainDataBean.getPicture().size();i++) {
            fragList.add(new WatchPicFragment(trainDataBean.getPicture().get(i).getUrl()));
        }
        adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),fragList);
        initViewPager();
        getData();
    }
}
