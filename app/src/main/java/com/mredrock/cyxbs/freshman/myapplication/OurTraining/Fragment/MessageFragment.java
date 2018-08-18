package com.mredrock.cyxbs.freshman.myapplication.OurTraining.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mredrock.cyxbs.freshman.myapplication.OurTraining.Activity.WatchPictureActivity;
import com.mredrock.cyxbs.freshman.myapplication.OurTraining.BannerView;
import com.mredrock.cyxbs.freshman.myapplication.OurTraining.BannerView2;
import com.mredrock.cyxbs.freshman.myapplication.OurTraining.Bean.TrainDataBean;
import com.mredrock.cyxbs.freshman.myapplication.OurTraining.TrainingPresenter;
import com.mredrock.cyxbs.freshman.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 军训风采界面
 */

public class MessageFragment extends Fragment{

    private ViewPager pager;
    private List<Fragment> fragList;
    private BannerView bannerView;

    private ViewPager pager2;
    private List<Fragment> fragList2;
    private BannerView2 bannerView2;
    private TrainDataBean trainDataBean;

    private LinearLayout linearLayout;
    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.freshman_message_fragment, null);

        new TrainingPresenter(this);
        init(view);
        initViewPager();

        return view;
    }

    //初始化
    public void init(View view){
        linearLayout = view.findViewById(R.id.fragment_recommend_banner_indicator);
        textView = view.findViewById(R.id.text);

        //军训视频模块
        fragList = new ArrayList<>();
        pager = view.findViewById(R.id.fragment_recommend_viewPager);
        bannerView = view.findViewById(R.id.bannerView);

        //军训图片模块
        fragList2 = new ArrayList<>();
        pager2 = view.findViewById(R.id.fragment_recommend_viewPager2);
        bannerView2 = view.findViewById(R.id.bannerView2);

    }

    //设置viewpager
    public void initViewPager(){
        //军训视频模块
        bannerView.show(getFragmentManager(),fragList);
        //军训图片模块
        bannerView2.show(getFragmentManager(),fragList2);
        pager2.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setText(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if(state == 1)
                    setGone();
            }
        });
    }

    public void getBean(TrainDataBean trainDataBean) {
        this.trainDataBean = trainDataBean;
        if(trainDataBean != null) {
            //军训视频
            for(int i=0;i<trainDataBean.getVideo().size();i++) {
                fragList.add(new ImageFragment(trainDataBean.getVideo().get(i).getVideo_pic().getUrl(), trainDataBean.getVideo().get(i).getName(), i));
            }

            //军训图片
            for(int i=0;i<trainDataBean.getPicture().size();i++){
                fragList2.add(new PictureFragment(trainDataBean.getPicture().get(i).getUrl(),i));
            }

            bannerView.show(getFragmentManager(),fragList);
            bannerView2.show(getFragmentManager(), fragList2);
        }

    }
    public void watchVideo(int pos) {
        if(trainDataBean != null){
            Uri uri = Uri.parse(trainDataBean.getVideo().get(pos).getUrl());
            Intent intent = new Intent(Intent.ACTION_VIEW,uri );
            startActivity(intent);
        }
    }

    public void watchPic(int i) {
        Intent intent = new Intent(getActivity(),WatchPictureActivity.class);
        intent.putExtra("pos",i + "");
        startActivity(intent);
    }

    public void setText(int position) {
        linearLayout.setVisibility(View.VISIBLE);
        textView.setText(trainDataBean.getPicture().get(position).getName());
    }

    public void setGone() {
        linearLayout.setVisibility(View.GONE);
    }
}
