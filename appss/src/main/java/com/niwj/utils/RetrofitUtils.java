package com.niwj.utils;

import com.niwj.utils.Intercept;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Zhijun on 2018/1/10.
 */

public class RetrofitUtils {
    //http://lf.snssdk.com/neihan/service/tabs/
    public static final String BASE_URL ="http://lf.snssdk.com/neihan/";
    private static volatile RetrofitUtils instance;
    private   OkHttpClient client;
    private static ApiService apiService;

    private RetrofitUtils (){
        client = new OkHttpClient.Builder().addInterceptor(new Intercept()).build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(Api.ANOTHER_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    public static RetrofitUtils getInstance(){
        if(instance==null){
            synchronized (RetrofitUtils.class){
                if(null==instance){
                    instance = new RetrofitUtils();
                }
            }
        }
        return  instance;
    }


    public ApiService getApiService(){
        return apiService;
    }

}
