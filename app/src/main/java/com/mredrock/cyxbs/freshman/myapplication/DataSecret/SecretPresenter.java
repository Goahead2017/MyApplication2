package com.mredrock.cyxbs.freshman.myapplication.DataSecret;

import com.mredrock.cyxbs.freshman.myapplication.DataSecret.Activity.SecretFirstPage;

import java.util.List;

public class SecretPresenter implements SecretInterface.Presenter {

    private SecretFirstPage secretFirstPage;

    public SecretPresenter(SecretFirstPage secretFirstPage){
        this.secretFirstPage = secretFirstPage;
        new FirstPageModel(this).request();
    }

    //获取学院名称
    @Override
    public void getSchoolName(List<String> name) {
        secretFirstPage.getName(name);
    }

}

