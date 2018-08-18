package com.mredrock.cyxbs.freshman.myapplication.DataSecret;

import com.mredrock.cyxbs.freshman.myapplication.DataSecret.Bean.CourseDataBean;
import com.mredrock.cyxbs.freshman.myapplication.DataSecret.Fragment.CourseFragment;

public class CoursePresenter {

    private CourseFragment courseFragment;

    public CoursePresenter(CourseFragment courseFragment, String schoolName) {
        this.courseFragment = courseFragment;
        new CourseModel(this,schoolName).request();
    }

    public void getData(CourseDataBean courseDataBean) {
        courseFragment.getData(courseDataBean);
    }
}

