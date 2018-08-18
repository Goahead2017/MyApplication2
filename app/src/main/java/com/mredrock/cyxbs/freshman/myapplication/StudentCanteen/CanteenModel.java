package com.mredrock.cyxbs.freshman.myapplication.StudentCanteen;

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

public class CanteenModel {

    public interface GetRequest_Interface {

        @GET("byindex")
        Call<CanteenDataBean> getCall(@Query("index")String index,@Query("pagenum")int pagenum,@Query("pagesize")int pagesize);
        // 注解里传入 网络请求 的部分URL地址
        // Retrofit把网络请求的URL分成了两部分：一部分放在Retrofit对象里，另一部分放在网络请求接口里
        // 如果接口里的url是一个完整的网址，那么放在Retrofit对象里的URL可以忽略
        // getCall()是接受网络请求数据的方法
    }

    public void request() {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://47.106.33.112:8080/welcome2018/data/get/") // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 支持RxJava平台
                .build();

        // 步骤5:创建 网络请求接口 的实例
        final CanteenModel.GetRequest_Interface request = retrofit.create(CanteenModel.GetRequest_Interface.class);

        //对 发送请求 进行封装
        Call<CanteenDataBean> call = request.getCall("学生食堂",1,2);


        //步骤6:发送网络请求(异步)
        call.enqueue(new Callback<CanteenDataBean>() {

            @Override
            public void onResponse(Call<CanteenDataBean> call, Response<CanteenDataBean> response) {

            }

            @Override
            public void onFailure(Call<CanteenDataBean> call, Throwable t) {

            }
        });

    }

}
