package com.mredrock.cyxbs.freshman.myapplication.DataSecret.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.mredrock.cyxbs.freshman.myapplication.DataSecret.Adapter.SecretAdapter;
import com.mredrock.cyxbs.freshman.myapplication.DataSecret.SecretInterface;
import com.mredrock.cyxbs.freshman.myapplication.DataSecret.SecretPresenter;
import com.mredrock.cyxbs.freshman.myapplication.InvisibleBar;
import com.mredrock.cyxbs.freshman.myapplication.R;

import java.util.List;

public class SecretFirstPage extends AppCompatActivity implements SecretInterface.View {

    private ImageView firstBack;

    //设置列表菜单
    RecyclerView mRecyclerView;
    SecretAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.freshman_secret_first_page);
        InvisibleBar.initStatusBar(getWindow());
        //初始化控件
        init();
        new SecretPresenter(this);
    }

    private void setItemListener() {
       mAdapter.setOnItemClickListener(new com.mredrock.cyxbs.freshman.myapplication.DataSecret.OnItemClickListener(){

           @Override
           public void onSecretClick(ImageView secretClick, TextView secretText,int position) {
               Intent intent = new Intent(SecretFirstPage.this, FindSecretActivity.class);
               intent.putExtra("schoolName",secretText.getText().toString());
               startActivity(intent);
           }
       });
    }

    private void init() {
        mRecyclerView = findViewById(R.id.secret_recycler_view);
        firstBack = findViewById(R.id.first_back);
        firstBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    //获取学院名称
    @Override
    public void getName(final List<String> name) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(name != null) {
                    //设置数据适配器
                    mAdapter = new SecretAdapter(name);
                    mRecyclerView.setAdapter(mAdapter);

                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                    mRecyclerView.setLayoutManager(linearLayoutManager);
                    mRecyclerView.setItemAnimator(new DefaultItemAnimator());

                    //设置RecycleView的item的监听
                    setItemListener();
                }
                Log.d("net", "getName: " + name);
            }
        });
    }
}
