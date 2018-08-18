package com.mredrock.cyxbs.freshman.myapplication.EnterSchool;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mredrock.cyxbs.freshman.myapplication.R;

import java.util.List;

public class SimpleAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private List<String> mData;
    //用于对点击蓝色方框的监听
    private boolean flag = false;

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mOnItemClickListener = listener;
    }


    SimpleAdapter(List<String> data){
        this.mData = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        View view = mInflater.inflate(R.layout.freshman_entrance_item,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int pos) {
        holder.tv.setText(mData.get(pos));

        //对item左侧进行监听
        if(mOnItemClickListener != null) {

            holder.blueBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnItemClickListener.onBlueClick(holder.blueBox, holder.tv, pos);
                }
            });

//                if(!mData.get(pos).equals(" 录取通知书") &&
//                        !mData.get(pos).equals(" 高考准考证") &&
//                        !mData.get(pos).equals(" 身份证") &&
//                        !mData.get(pos).equals("《新生适应性资料》学习心得") &&
//                        !mData.get(pos).equals(" 同版近期证件张照15") &&
//                        !mData.get(pos).equals("《学生管理与学生自律协议书》") &&
//                        !mData.get(pos).equals("《致2018级新生的一封信》") &&
//                        !mData.get(pos).equals(" 社会实践报告") &&
//                        !mData.get(pos).equals(" 团员证") &&
//                        !mData.get(pos).equals(" 转团组织关系资料")){
//                    holder.blueBox.setImageResource(R.drawable.freshman_delete_blue);
//                }else {
//                    holder.blueBox.setVisibility(View.GONE);
//                }

            if(StaticData.edit) {
                if (!mData.get(pos).equals(" 录取通知书") &&
                        !mData.get(pos).equals(" 高考准考证") &&
                        !mData.get(pos).equals(" 身份证") &&
                        !mData.get(pos).equals("《新生适应性资料》学习心得") &&
                        !mData.get(pos).equals(" 同版近期证件张照15") &&
                        !mData.get(pos).equals("《学生管理与学生自律协议书》") &&
                        !mData.get(pos).equals("《致2018级新生的一封信》") &&
                        !mData.get(pos).equals(" 社会实践报告") &&
                        !mData.get(pos).equals(" 团员证") &&
                        !mData.get(pos).equals(" 转团组织关系资料")) {
                    holder.blueBox.setImageResource(R.drawable.freshman_delete_blue);
                }else {
                    holder.blueBox.setVisibility(View.GONE);
                }
            }

            //对item右侧箭头设置监听
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnItemClickListener.onImageClick(holder.imageView, pos);
                    TextView textView = holder.itemView.findViewById(R.id.id_expand_view);
                    if (!flag) {
                        textView.setVisibility(View.VISIBLE);
                        flag = true;
                    } else {
                        textView.setVisibility(View.GONE);
                        flag = false;
                    }
                }
            });

            if (StaticData.flag && !StaticData.edit) {
                holder.imageView.setVisibility(View.GONE);
            }
        }

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

  /*  void addData(int position){
        mData.add(position,"Insert one");
        notifyItemInserted(position);
        notifyItemChanged(position,mData.size()-position);
    }

    void deleteData(int position){
        mData.remove(position);
        notifyItemRemoved(position);
        notifyItemChanged(position,mData.size()-position);
    }*/

}

class MyViewHolder extends RecyclerView.ViewHolder{

    TextView tv;
    ImageView blueBox;
    ImageView imageView;

    MyViewHolder(View view){
        super(view);
        tv = view.findViewById(R.id.tv);
        blueBox = view.findViewById(R.id.blue_box);
        imageView = view.findViewById(R.id.image);
    }

}
