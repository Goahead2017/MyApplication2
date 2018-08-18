package com.mredrock.cyxbs.freshman.myapplication.DataSecret;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * 回调监听item相应控件的点击变化
 */

public interface OnItemClickListener {
    void onSecretClick(ImageView secretClick,TextView secretText, int position);
}