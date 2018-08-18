package com.mredrock.cyxbs.freshman.myapplication.DataSecret;

import java.util.List;

public interface SecretInterface {

    interface View{
        //获取学院名称
        void getName(List<String>name);
    }

    interface Presenter{
        //获取学院名称
        void getSchoolName(List<String>name);
    }
}
