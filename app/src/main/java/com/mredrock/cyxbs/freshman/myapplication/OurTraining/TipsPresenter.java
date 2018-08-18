package com.mredrock.cyxbs.freshman.myapplication.OurTraining;

import com.mredrock.cyxbs.freshman.myapplication.OurTraining.Bean.TipsDataBean;
import com.mredrock.cyxbs.freshman.myapplication.OurTraining.Fragment.TipsFragment;

public class TipsPresenter {

    private TipsFragment tipsFragment;

    public TipsPresenter(TipsFragment tipsFragment) {
        this.tipsFragment = tipsFragment;
        new TipsModel(this).request();
    }

    public void getMessage(TipsDataBean tipsDataBean) {
        tipsFragment.getMessage(tipsDataBean);
    }
}
