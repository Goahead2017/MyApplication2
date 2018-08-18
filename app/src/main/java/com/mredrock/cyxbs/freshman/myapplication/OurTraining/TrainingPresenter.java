package com.mredrock.cyxbs.freshman.myapplication.OurTraining;

import com.mredrock.cyxbs.freshman.myapplication.OurTraining.Activity.WatchPictureActivity;
import com.mredrock.cyxbs.freshman.myapplication.OurTraining.Bean.TrainDataBean;
import com.mredrock.cyxbs.freshman.myapplication.OurTraining.Fragment.MessageFragment;
import com.mredrock.cyxbs.freshman.myapplication.OurTraining.Fragment.WatchPicFragment;

public class TrainingPresenter {

    private MessageFragment messageFragment;
    private WatchPictureActivity watchPictureActivity;

    public TrainingPresenter(MessageFragment messageFragment) {
        this.messageFragment = messageFragment;
        new TrainingModel(this).request();
    }

    public TrainingPresenter(WatchPictureActivity watchPictureActivity) {
        this.watchPictureActivity = watchPictureActivity;
        new TrainingModel(this).request();
    }

    public void getBean(TrainDataBean trainDataBean) {
        if(messageFragment != null) {
            messageFragment.getBean(trainDataBean);
        }
        if(watchPictureActivity != null){
            watchPictureActivity.getBean(trainDataBean);
        }
    }
}
