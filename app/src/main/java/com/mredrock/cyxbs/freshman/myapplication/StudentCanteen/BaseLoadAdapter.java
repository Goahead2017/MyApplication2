package com.mredrock.cyxbs.freshman.myapplication.StudentCanteen;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mredrock.cyxbs.freshman.myapplication.R;

import java.util.List;

public class BaseLoadAdapter<T> extends RecyclerView.Adapter {

    public List<T> list;
    public static final int TYPE_OTHER = 1;
    public static final int TYPE_BOTTOM = 2;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (TYPE_BOTTOM == viewType) {
            //返回我们的那个加载中的布局Viewholder
            return new NewBottomViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.freshman_bottom_item, parent, false));
        } else {
            //返回我们的交易记录的布局Viewholder
            return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.freshman_common_item, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_BOTTOM) {
            //对相应的onBindViewHolder进行处理
//            LinearLayout container = ((BaseLoadMoreAdapter.NewBottomViewHolder) holder).container;
//            final ProgressBar pb = ((BaseLoadMoreAdapter.NewBottomViewHolder) holder).pb;
//            final TextView content = ((BaseLoadMoreAdapter.NewBottomViewHolder) holder).content;

        } else {
            //对具体的交易记录的itemView进行相应的控件进行处理。
//            TransferExamItemBean bean = ((TransferExamItemBean) list.get(position));
//            holder.itemView.setTag(bean);
//            ((ExamRefreshAdapter.MyViewHolder) holder).name.setText(bean.getToCompanyName());
//            ((ExamRefreshAdapter.MyViewHolder) holder).date.setText(bean.getCreateDate());
//            ((ExamRefreshAdapter.MyViewHolder) holder).money.setText(bean.getAmount()+"");
        }
    }

    @Override
    public int getItemCount() {
        return list.size() < 4 ? list.size() : list.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (!list.isEmpty() && list.size() < position ) {
            return TYPE_OTHER;
        } else {
            return TYPE_BOTTOM;
        }
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {

    MyViewHolder(View view) {
        super(view);
    }
}

class NewBottomViewHolder extends RecyclerView.ViewHolder {

    NewBottomViewHolder(View view) {
        super(view);
    }
}