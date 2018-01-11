package com.niwj.adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.niwj.bean.MessageBean;
import com.niwj.neihandz.R;

import java.util.List;

/**
 * Created by Zhijun on 2018/1/10.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHoder> {
    private Context context;
    private List<MessageBean.DataBeanX.DataBean> data;

    public HomeAdapter(Context context, List<MessageBean.DataBeanX.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public ViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        View.inflate(context, R.layout.home_item,null);
        return null;
    }


    @Override
    public void onBindViewHolder(ViewHoder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHoder extends RecyclerView.ViewHolder{

        public ViewHoder(View itemView) {
            super(itemView);
        }
    }
}
