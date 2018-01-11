package com.niwj.presenter;

import com.niwj.bean.MessageBean;
import com.niwj.model.Imodel;
import com.niwj.view.IView;

import org.reactivestreams.Subscriber;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by Zhijun on 2018/1/10.
 */

public class NewsPresenter  implements NewsBasePresenter{
    private IView iv;
    public void attach(IView iv){
        this.iv=iv;
    }

    @Override
    public void getData(String type) {
        Imodel imodel = new Imodel(this);
    }

    public void getNews(Flowable flowable) {
        Subscriber subscriber = flowable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber() {
                    @Override
                    public void onNext(Object o) {
                        if(o!=null){
                            MessageBean bean = (MessageBean)o;
                            iv.Success(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
