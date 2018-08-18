package com.mredrock.cyxbs.freshman.myapplication.DataSecret.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.cyxbs.freshman.myapplication.DataSecret.Bean.CourseDataBean;
import com.mredrock.cyxbs.freshman.myapplication.DataSecret.CourseModel;
import com.mredrock.cyxbs.freshman.myapplication.DataSecret.CoursePresenter;
import com.mredrock.cyxbs.freshman.myapplication.DataSecret.DIYView.CourseDrawView;
import com.mredrock.cyxbs.freshman.myapplication.R;

public class CourseFragment extends Fragment {

    private String schoolName;
    private CourseDrawView courseDrawView;

    protected boolean isInit = false;
    protected boolean isLoad = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.freshman_fragment_course,null);

        isInit = true;
        isCanLoadData();
        courseDrawView = view.findViewById(R.id.courseView);
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isCanLoadData();
    }

    public void getSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public void getData(CourseDataBean courseDataBean) {
        courseDrawView.getData(courseDataBean);
    }

    private void isCanLoadData() {
        if (!isInit) {
            return;
        }

        if (getUserVisibleHint()) {
            new CoursePresenter(this,schoolName);
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

    protected void stopLoad() {
    }

}
