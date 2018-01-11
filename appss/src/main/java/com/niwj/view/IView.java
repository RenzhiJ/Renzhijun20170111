package com.niwj.view;

/**
 * Created by Zhijun on 2018/1/10.
 */

public interface IView {
    void  Success(Object o);
    void  onFaled(Exception e);
}
