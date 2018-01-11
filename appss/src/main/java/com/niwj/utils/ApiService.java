package com.niwj.utils;

import com.niwj.bean.MessageBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Zhijun on 2018/1/10.
 */

public interface ApiService {
    @GET("mix/v1/?")
    Flowable<MessageBean> Tuijian(@Query("content_type") String type);
}
