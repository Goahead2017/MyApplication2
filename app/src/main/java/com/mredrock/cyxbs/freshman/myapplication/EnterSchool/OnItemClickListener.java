package com.mredrock.cyxbs.freshman.myapplication.EnterSchool;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * 回调监听item相应控件的点击变化
 */

public interface OnItemClickListener {
    void onBlueClick(ImageView blueBox, TextView tv, int position);
    void onImageClick(ImageView imageView,int position);
}