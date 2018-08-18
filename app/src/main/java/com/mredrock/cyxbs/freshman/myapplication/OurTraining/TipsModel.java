package com.mredrock.cyxbs.freshman.myapplication.OurTraining;

import android.support.annotation.NonNull;
import android.util.Log;

import com.mredrock.cyxbs.freshman.myapplication.OurTraining.Bean.TipsDataBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class TipsModel {

    private TipsPresenter tipsPresenter;

    public TipsModel(TipsPresenter tipsPresenter) {
        this.tipsPresenter = tipsPresenter;
    }

    public interface GetRequest_Interface {

        @GET("describe")
        Call<TipsDataBean> getCall(@Query("index")String index);
    }

    public void request() {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(" http://47.106.33.112:8080/welcome2018/data/get/") // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 支持RxJava平台
                .build();

        // 步骤5:创建 网络请求接口 的实例
        final TipsModel.GetRequest_Interface request = retrofit.create(TipsModel.GetRequest_Interface.class);

        //对 发送请求 进行封装
        Call<TipsDataBean> call = request.getCall("军训小贴士");


        //步骤6:发送网络请求(异步)
        call.enqueue(new Callback<TipsDataBean>() {
            @Override
            public void onResponse(@NonNull Call<TipsDataBean> call, @NonNull Response<TipsDataBean> response) {
                TipsDataBean tipsDataBean= response.body();
                tipsPresenter.getMessage(tipsDataBean);
                Log.d("tips", "onResponse: " + tipsDataBean.getDescribe().get(0).getProperty() + "," + tipsDataBean.getDescribe().size());
            }

            @Override
            public void onFailure(@NonNull Call<TipsDataBean> call, @NonNull Throwable t) {
                Log.d("train", "onFailure: " + "error");
            }


        });

    }

}
