package com.mredrock.cyxbs.freshman.myapplication.EnterSchool;

import android.support.annotation.NonNull;
import android.util.Log;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class EntranceModel {

    public interface GetRequest_Interface {

        @GET("describe")
        Call<ResponseBody> getCall(@Query("index")String index);
    }

    public void request() {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(" http://118.24.175.82/data/get/") // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 支持RxJava平台
                .build();

        // 步骤5:创建 网络请求接口 的实例
        final GetRequest_Interface request = retrofit.create(GetRequest_Interface.class);

        //对 发送请求 进行封装
        Call<ResponseBody> call = request.getCall("入学必备");


        //步骤6:发送网络请求(异步)
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                String data = null;
                try {
                    data = response.body().string();
                    Log.d("Net", "onResponse: " + data );
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                Log.d("Net", "onFailure: " + "连接失败");
            }

        });

    }
}


