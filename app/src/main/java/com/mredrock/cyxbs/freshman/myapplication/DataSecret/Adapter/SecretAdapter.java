package com.mredrock.cyxbs.freshman.myapplication.DataSecret.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mredrock.cyxbs.freshman.myapplication.DataSecret.OnItemClickListener;
import com.mredrock.cyxbs.freshman.myapplication.R;

import java.util.List;

public class SecretAdapter extends RecyclerView.Adapter<SecretAdapter.MyViewHolder> {

    private List<String> mData;
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener listener){
        this.onItemClickListener = listener;
    }

    public SecretAdapter(List<String> data){
        this.mData = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        View view = mInflater.inflate(R.layout.freshman_secret_item,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        if (holder.tv != null)
        holder.tv.setText(mData.get(position));

        if(holder.click != null)
        holder.click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onSecretClick(holder.click,holder.tv,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv;
        private ImageView click;

        MyViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.secret_tv);
            click = itemView.findViewById(R.id.secret_click);
        }
    }


}
