package com.mredrock.cyxbs.freshman.myapplication.EnterSchool;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.mredrock.cyxbs.freshman.myapplication.InvisibleBar;
import com.mredrock.cyxbs.freshman.myapplication.R;

import java.util.ArrayList;

import static com.mredrock.cyxbs.freshman.myapplication.EnterSchool.StaticData.*;

public class EntranceActivity extends AppCompatActivity implements View.OnClickListener{

    //设置列表菜单
    RecyclerView mRecyclerView;
    com.mredrock.cyxbs.freshman.myapplication.EnterSchool.SimpleAdapter mAdapter;
    Boolean flag1 = false;
    Boolean flag2 = false;

    //设置添加按钮
    protected FloatingActionButton floatButton;
    //设置添加栏
    protected LinearLayout linear;

    //设置添加
    protected EditText et;
    protected Button bt;

    //设置详情监听
    protected ImageView detail;
    DetailedDialog detailedDialog;

    //设置删除
    protected Boolean flag = false;
    protected TextView edit;
    int num = 0;
    protected ArrayList<String> record;
    int i = 0;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.freshman_entrance);

        new EntranceModel().request();

        //初始化控件
        init();
        //解决输入法遮盖底部控件
        InputMethod();
        //设置沉浸式状态栏
        InvisibleBar.initStatusBar(getWindow());
        //初始化数据
        initData();

        //设置数据适配器
        mAdapter = new com.mredrock.cyxbs.freshman.myapplication.EnterSchool.SimpleAdapter(StaticData.data);
        mRecyclerView.setAdapter(mAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        //设置RecycleView的item的监听
        setItemListener();

    }

    //实例化控件
    public void init(){
        floatButton = findViewById(R.id.floatButton);
        floatButton.setOnClickListener(this);
        linear = findViewById(R.id.linear);
        mRecyclerView = findViewById(R.id.recycler_view);

        et = findViewById(R.id.et);
        bt = findViewById(R.id.bt);
        bt.setOnClickListener(this);

        detail = findViewById(R.id.detail);
        detail.setOnClickListener(this);

        edit = findViewById(R.id.edit);
        edit.setOnClickListener(this);

        record = new ArrayList<>();
    }

    //解决输入法遮盖底部控件
    public void InputMethod(){
        Resources resources = this.getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height","dimen", "android");
        final int navHeight = resources.getDimensionPixelSize(resourceId);
        linear.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Rect rect = new Rect();
                getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);      //获取界面的可视高度(不被键盘遮挡的这部分)
                int parentHeight = linear.getRootView().getHeight();    //屏幕高度(包含了状态栏和虚拟导航栏)
                int coveredHeight = parentHeight - rect.bottom;     //被覆盖的高度(包含了虚拟导航栏)
                if (coveredHeight > 0) {    //当界面发生了形变时才去设置
                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) linear.getLayoutParams();
                    params.bottomMargin = coveredHeight - navHeight;        //减去虚拟导航栏的高度后才是真正被键盘遮盖的高度
                    linear.requestLayout();
                }
            }
        });
    }

    //初始化适配器中的数据
    public void initData(){
        StaticData.data = new ArrayList<>();
        StaticData.data.add(" 录取通知书");
        StaticData.data.add(" 高考准考证");
        StaticData.data.add(" 身份证");
        StaticData.data.add("《新生适应性资料》学习心得");
        StaticData.data.add(" 同版近期证件张照15");
        StaticData.data.add("《学生管理与学生自律协议书》");
        StaticData.data.add("《致2018级新生的一封信》");
        StaticData.data.add(" 社会实践报告");
        StaticData.data.add(" 团员证");
        StaticData.data.add(" 转团组织关系资料");
        StaticData.data.add(" 学籍档案");
        StaticData.data.add(" 本人户口本内页");
        StaticData.data.add("《常住人口登记表》");
        StaticData.data.add(" 本人户口迁移证");
        StaticData.data.add(" 免冠一寸登记表");
        StaticData.data.add(" 党员档案");
        StaticData.data.add(" 转党组织关系相关资料");
        StaticData.data.add(" 困难证明的原件和复印件");
    }

    //设置RecycleView的item的监听
    public void setItemListener(){
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onBlueClick(ImageView blueBox, TextView tv, int position) {
                if (!flag1 && !StaticData.edit) {
                    blueBox.setImageResource(R.drawable.freshman_blue1);
                    tv.setTextColor(getResources().getColor(R.color.text1));
                    flag1 = true;

                } else if (flag1 && !StaticData.edit) {
                    blueBox.setImageResource(R.drawable.freshman_blue0);
                    tv.setTextColor(getResources().getColor(R.color.text0));
                    flag1 = false;
                } else if (StaticData.edit) {
                    i --;
                    blueBox.setImageResource(R.drawable.freshman_delete_ok);
//                    record.add(position,StaticData.data.get(position));
                    record.add(StaticData.data.get(position));
                    num++;
                    text = "删除" + "(" + num + ")";
                    edit.setText(text);
                } else if(StaticData.edit){
                    blueBox.setImageResource(R.drawable.freshman_delete_blue);
//                    if(position < record.size())
//                    record.remove(position);
                    for (int i = 0; i < record.size(); i++) {
                        if (record.get(i).equals(StaticData.data.get(position))) {
                            record.remove(i);
                        }
                    }
                    num--;
                    text = "删除" + "(" + num + ")";
                    edit.setText(text);
                }
            }

            @Override
            public void onImageClick(ImageView imageView, int position) {
                if (!flag2) {
                    imageView.setImageResource(R.drawable.freshman_above);
                    flag2 = true;
                } else {
                    imageView.setImageResource(R.drawable.freshman_below);
                    flag2 = false;
                }
            }

        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.floatButton:
                floatButton.setVisibility(View.GONE);
                linear.setVisibility(View.VISIBLE);
                StaticData.flag = true;
                mAdapter.notifyDataSetChanged();
                break;
            case R.id.bt:
                String str = et.getText().toString();
                if(str.equals("")){
                    Toast.makeText(getApplicationContext(),"请输入待办事项（不超过14个字）",Toast.LENGTH_SHORT).show();
                }else {
                    StaticData.data.add(str);
                    linear.setVisibility(View.GONE);
                    floatButton.setVisibility(View.VISIBLE);
                    InputMethodManager inputManager = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    if (inputManager != null) {
                        inputManager.hideSoftInputFromWindow(et.getWindowToken(),0);
                    }
                    StaticData.flag = false;
                    mRecyclerView.setAdapter(mAdapter);
                }
                break;
            case R.id.detail:
                detailedDialog=new DetailedDialog(this,R.style.Dialog);
                detailedDialog.show();
                break;
            case R.id.edit:
                if(!flag){
                    text = "删除"+ "(" + num + ")";
                    StaticData.edit = true;
                    flag = true;
//                    mAdapter.notifyDataSetChanged();
                    mRecyclerView.setAdapter(mAdapter);
                }else {
                    text = "编辑";
                    for(int i = 0; i< StaticData.data.size(); i++){
                        for(int j=0;j<record.size();j++){
                            if(StaticData.data.get(i).equals(record.get(j))){
                                StaticData.data.remove(i);
                            }
                        }
                    }
                    flag = false;
                    StaticData.edit = false;
                    mRecyclerView.setAdapter(mAdapter);
                }
                edit.setText(text);
                num = 0;
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(detailedDialog != null){
            detailedDialog.dismiss();
        }
    }

}

