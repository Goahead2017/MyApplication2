package com.mredrock.cyxbs.freshman.myapplication.OurTraining.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mredrock.cyxbs.freshman.myapplication.OurTraining.Bean.TipsDataBean;
import com.mredrock.cyxbs.freshman.myapplication.OurTraining.TipsPresenter;
import com.mredrock.cyxbs.freshman.myapplication.R;

public class TipsFragment extends Fragment {

    private TextView tipsText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.freshman_tips_fragment,null);
        tipsText = view.findViewById(R.id.tips_text);
        new TipsPresenter(this);
        return view;
    }

    @SuppressLint("SetTextI18n")
    public void getMessage(TipsDataBean tipsDataBean) {
        for(int i = 0;i<tipsDataBean.getDescribe().size();i++) {
            if (tipsDataBean.getDescribe().get(i).getProperty().equals("加粗")) {
                TextPaint paint = tipsText.getPaint();
                paint.setFakeBoldText(true);
            }else {
                TextPaint paint = tipsText.getPaint();
                paint.setFakeBoldText(false);
            }

            tipsText.append(tipsDataBean.getDescribe().get(i).getContent());
            tipsText.append("\n");
        }
    }
}
