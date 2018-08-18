package com.mredrock.cyxbs.freshman.myapplication.OurTraining;

import android.support.annotation.NonNull;
import android.util.Log;

import com.mredrock.cyxbs.freshman.myapplication.OurTraining.Bean.TrainDataBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class TrainingModel {

    private TrainingPresenter trainingPresenter;

    public TrainingModel(TrainingPresenter trainingPresenter) {
        this.trainingPresenter = trainingPresenter;
    }

    public interface GetRequest_Interface {

        @GET("junxun")
        Call<TrainDataBean> getCall();
    }

    public void request() {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://47.106.33.112:8080/welcome2018/data/get/") // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 支持RxJava平台
                .build();

        // 步骤5:创建 网络请求接口 的实例
        final TrainingModel.GetRequest_Interface request = retrofit.create(TrainingModel.GetRequest_Interface.class);

        //对 发送请求 进行封装
        Call<TrainDataBean> call = request.getCall();


        //步骤6:发送网络请求(异步)
        call.enqueue(new Callback<TrainDataBean>() {
            @Override
            public void onResponse(@NonNull Call<TrainDataBean> call, @NonNull Response<TrainDataBean> response) {
                TrainDataBean trainDataBean = response.body();
                Log.d("train", "onResponse: " + trainDataBean.getPicture().get(0).getName() + "," + trainDataBean.getPicture().get(0).getUrl() + "," + trainDataBean.getPicture().size());
                trainingPresenter.getBean(trainDataBean);
            }

            @Override
            public void onFailure(@NonNull Call<TrainDataBean> call, @NonNull Throwable t) {
                Log.d("train", "onFailure: " + "error");
            }

        });

    }
}
