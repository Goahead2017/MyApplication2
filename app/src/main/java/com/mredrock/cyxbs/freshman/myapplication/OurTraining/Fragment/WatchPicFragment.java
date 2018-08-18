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

public class WatchPicFragment extends Fragment {

    private ImageView iv;
    public String url = "http://47.106.33.112:8080/welcome2018";

    public WatchPicFragment(){}

    @SuppressLint("ValidFragment")
    public WatchPicFragment(String url){
        this.url = this.url + url;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.freshman_watch_pic, null);
        iv = view.findViewById(R.id.iv);
        Glide.with(getContext()).load(Uri.parse(url)).asBitmap().into(iv);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });
        return view;
    }
}
