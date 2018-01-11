package com.niwj.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.niwj.adpter.HomeAdapter;
import com.niwj.bean.MessageBean;
import com.niwj.neihandz.R;
import com.niwj.presenter.NewsPresenter;
import com.niwj.view.IView;

import java.util.List;


public class OnLineFragment extends Fragment implements IView {
    private View view;
    private RecyclerView mOnRecy;
    private LinearLayoutManager manager;

    //首页
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_online, null);
        NewsPresenter newsPresenter = new NewsPresenter();
        newsPresenter.attach(this);
        newsPresenter.getData(-101+"");
        manager = new LinearLayoutManager(getContext());
        initView(view);
        return view;
    }

    private void initView(View view) {
        mOnRecy = (RecyclerView) view.findViewById(R.id.onRecy);
    }

    @Override
    public void Success(Object o) {
        MessageBean bean = (MessageBean)o;
        List<MessageBean.DataBeanX.DataBean> data = bean.getData().getData();
        if(data!=null){
            HomeAdapter homeAdapter = new HomeAdapter(getContext(),data);
            mOnRecy.setLayoutManager(manager);
            mOnRecy.setAdapter(homeAdapter);
        }
    }

    @Override
    public void onFaled(Exception e) {

    }
}
