package com.mredrock.cyxbs.freshman.myapplication.OurTraining;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * 配置滑动界面的数据适配器
 */

public class BannerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment>fragList;
    private double num;

    public BannerAdapter(FragmentManager fm, List<Fragment> fragList, double num) {
        super(fm);
        this.fragList = fragList;
        this.num = num;
    }

    @Override
    public Fragment getItem(int position) {
        return fragList.get(position);
    }

    @Override
    public int getCount() {
        return fragList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup arg0,int arg1){
        return super.instantiateItem(arg0,arg1);

    }

    @Override
    public float getPageWidth(int position) {
        return (float) num;
    }


    @Override
    public void destroyItem(ViewGroup container,int position,Object object){
        super.destroyItem(container,position,object);
    }

}
