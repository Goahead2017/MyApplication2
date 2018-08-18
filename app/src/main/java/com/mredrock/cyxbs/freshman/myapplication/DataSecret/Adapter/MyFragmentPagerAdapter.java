package com.mredrock.cyxbs.freshman.myapplication.DataSecret.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * 配置滑动界面的数据适配器
 */

public class MyFragmentPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment>fragList;
    private List<String>titleList;

    public MyFragmentPagerAdapter(FragmentManager fm,List<Fragment>fragList,List<String>titleList) {
        super(fm);
        this.fragList = fragList;
        this.titleList = titleList;
    }

    public MyFragmentPagerAdapter(FragmentManager supportFragmentManager, List<Fragment> fragList) {
        super(supportFragmentManager);
        this.fragList = fragList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragList.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position){
        return titleList.get(position);
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
    public void destroyItem(ViewGroup container,int position,Object object){
        super.destroyItem(container,position,object);
    }

}
