package com.bw.week2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.week2.R;
import com.bw.week2.bean.MyBean;

import java.util.List;

public class PashAdapter extends RecyclerView.Adapter<PashAdapter.Holder> {
    List<MyBean.ResultBean.PzshBean.CommodityListBeanX> list;
    Context context;

    public PashAdapter(List<MyBean.ResultBean.PzshBean.CommodityListBeanX> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_pzsh, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        String name = list.get(position).getCommodityName();
        holder.tv.setText(name);
        String pic = list.get(position).getMasterPic();
        Glide.with(context).load(pic).placeholder(R.drawable.ic_launcher_background).into(holder.imv);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{

        ImageView imv;
        TextView tv;
        public Holder(@NonNull View itemView) {
            super(itemView);
            imv=itemView.findViewById(R.id.imv);
            tv=itemView.findViewById(R.id.tv);
        }
    }
}
