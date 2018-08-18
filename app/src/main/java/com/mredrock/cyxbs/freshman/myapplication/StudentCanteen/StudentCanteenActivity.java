package com.mredrock.cyxbs.freshman.myapplication.StudentCanteen;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.mredrock.cyxbs.freshman.myapplication.R;

public class StudentCanteenActivity extends AppCompatActivity {

    //是否使用特殊的标题栏颜色，android5.0以上可以设置状态栏背景色，如果不使用则使用透明色值
    protected boolean useThemestatusBarColor = false;
    //是否使用状态栏文字和图标为暗色，如果状态栏采用了白色系，则需要使状态栏和图标为暗色，android6.0以上可以设置
    protected boolean useStatusBarColor = true;

    private ImageView canBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.freshman_student_canteen);

        //设置沉浸式状态栏
        initStatusBar();

        new CanteenModel().request();

        canBack = findViewById(R.id.can_back);
        canBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    //设置沉浸式状态栏
    public void initStatusBar() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            //5.0及以上
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            //根据上面设置是否对状态栏单独设置颜色
            if(useThemestatusBarColor) {
//                getWindow().setStatusBarColor(getResources().getColor());
            }else {
                getWindow().setStatusBarColor(Color.TRANSPARENT);
            }
        }else if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            //4.4到5.0
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !useStatusBarColor){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

    }

}
