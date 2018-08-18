package com.mredrock.cyxbs.freshman.myapplication.OurTraining.Fragment;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mredrock.cyxbs.freshman.myapplication.R;

import java.util.List;

public class ImageFragment extends Fragment{

    private ImageView iv;
    private String url = "http://47.106.33.112:8080/welcome2018";
    private String text;
    private int pos;

    public ImageFragment(){}

    @SuppressLint("ValidFragment")
    public ImageFragment(String url, String text, int pos){
        this.url = this.url + url;
        this.text = text;
        this.pos = pos;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.freshman_image,null);
        ImageView play = view.findViewById(R.id.play);
        iv = view.findViewById(R.id.iv);
        TextView textView = view.findViewById(R.id.train_text);
        textView.setText(text);
        Glide.with(getContext()).load(Uri.parse(url)).asBitmap().into(iv);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Fragment> list=ImageFragment.this.getFragmentManager().getFragments();
                for(Fragment f:list){
                    if(f!=null&&f instanceof MessageFragment){
                        ((MessageFragment) f).watchVideo(pos);
                        break;
                    }
                }
            }
        });
        return view;
    }

}
