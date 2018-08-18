package com.mredrock.cyxbs.freshman.myapplication.OurTraining.Fragment;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mredrock.cyxbs.freshman.myapplication.R;

import java.util.List;

public class PictureFragment extends Fragment {

    private ImageView iv;
    private String url = "http://47.106.33.112:8080/welcome2018";
    private int pos;

    public PictureFragment(){}

    @SuppressLint("ValidFragment")
    public PictureFragment(String url, int pos){
        this.url = this.url + url;
        this.pos = pos;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.freshman_picture,null);
        iv = view.findViewById(R.id.iv);
        Glide.with(getContext()).load(Uri.parse(url)).asBitmap().into(iv);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Fragment>list=PictureFragment.this.getFragmentManager().getFragments();
                for(Fragment f:list){
                    if(f!=null&&f instanceof MessageFragment){
                        ((MessageFragment) f).watchPic(pos);
                        break;
                    }
                }
            }
        });
        return view;
    }
}
