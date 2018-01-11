package com.niwj.model;

import com.niwj.presenter.NewsPresenter;
import com.niwj.utils.RetrofitUtils;

import io.reactivex.Flowable;

/**
 * Created by Zhijun on 2018/1/10.
 */

public class Imodel {
    private  NewsPresenter presenter;

    public Imodel(NewsPresenter presenter) {
        this.presenter = presenter;
    }
    public void getData(String type){
        Flowable flowable = RetrofitUtils.getInstance().getApiService().Tuijian(type);
        presenter.getNews(flowable);
    }
}
