package com.mredrock.cyxbs.freshman.myapplication.DataSecret.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mredrock.cyxbs.freshman.myapplication.DataSecret.DIYView.SexDrawView;
import com.mredrock.cyxbs.freshman.myapplication.DataSecret.SexPresenter;
import com.mredrock.cyxbs.freshman.myapplication.R;

public class SexFragment extends Fragment {

    private SexDrawView sexDrawView;
    private String schoolName;

    private TextView sex;

    protected boolean isInit = false;
    protected boolean isLoad = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.freshman_fragment_sex,null);

        sexDrawView = view.findViewById(R.id.sex_draw);
        sex = view.findViewById(R.id.sex);
        sex.setText(schoolName + "男女比例");
        isInit = true;
        isCanLoadData();

        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isCanLoadData();
    }

    private void isCanLoadData() {
        if (!isInit) {
            return;
        }

        if (getUserVisibleHint()) {
            new SexPresenter(this,schoolName);
            isLoad = true;
        } else {
            if (isLoad) {
                stopLoad();
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isInit = false;
        isLoad = false;

    }

    public void getSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public void getAmount(int male, int female) {
        sexDrawView.getSex(male,female);
    }

    protected void stopLoad() {
    }
}
