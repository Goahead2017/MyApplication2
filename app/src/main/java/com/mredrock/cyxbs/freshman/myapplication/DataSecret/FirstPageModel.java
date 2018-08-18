package com.mredrock.cyxbs.freshman.myapplication.DataSecret;

import android.support.annotation.NonNull;
import android.util.Log;

import com.mredrock.cyxbs.freshman.myapplication.DataSecret.Bean.SchoolNameBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class FirstPageModel {

    private SecretPresenter secretPresenter;

    public FirstPageModel(SecretPresenter secretPresenter) {
        this.secretPresenter = secretPresenter;
    }

    public interface GetRequest_Interface {

        @GET("getname")
        Call<SchoolNameBean> getCall();
        // 注解里传入 网络请求 的部分URL地址
        // Retrofit把网络请求的URL分成了两部分：一部分放在Retrofit对象里，另一部分放在网络请求接口里
        // 如果接口里的url是一个完整的网址，那么放在Retrofit对象里的URL可以忽略
        // getCall()是接受网络请求数据的方法
    }

    public  void request() {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("  http://47.106.33.112:8080/welcome2018/search/school/") // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 支持RxJava平台
                .build();

        // 步骤5:创建 网络请求接口 的实例
        final GetRequest_Interface request = retrofit.create(GetRequest_Interface.class);

        //对 发送请求 进行封装
        Call<SchoolNameBean> call = request.getCall();


        //步骤6:发送网络请求(异步)
        call.enqueue(new Callback<SchoolNameBean>() {
            @Override
            public void onResponse(@NonNull Call<SchoolNameBean> call, @NonNull Response<SchoolNameBean> response) {
                List<String>name = response.body().getName();
                secretPresenter.getSchoolName(name);
                Log.d("net", "onResponse: " + name);
            }

            @Override
            public void onFailure(@NonNull Call<SchoolNameBean> call, @NonNull Throwable t) {
                Log.d("Net", "onFailure: " + "连接失败");
            }

        });

    }
}


