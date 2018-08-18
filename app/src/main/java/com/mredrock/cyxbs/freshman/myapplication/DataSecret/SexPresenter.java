package com.mredrock.cyxbs.freshman.myapplication.DataSecret;

import com.mredrock.cyxbs.freshman.myapplication.DataSecret.Fragment.SexFragment;

public class SexPresenter implements SexInterface.Presenter {

    private SexFragment sexFragment;

    public SexPresenter(SexFragment sexFragment , String schoolName) {
        this.sexFragment = sexFragment;
        new SexModel(this,schoolName).request();
    }

    public void getSexData(int male,int female) {
        sexFragment.getAmount(male,female);
    }
}

