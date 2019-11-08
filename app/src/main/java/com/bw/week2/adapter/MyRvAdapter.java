package com.bw.week2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.week2.R;
import com.bw.week2.bean.MyBean;

import java.util.List;

public class MyRvAdapter extends RecyclerView.Adapter<MyRvAdapter.Holder> {

    int type=0;
    MyBean myBean;
    Context context;

    public MyRvAdapter(MyBean myBean, Context context) {
        this.myBean = myBean;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_item, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        if (type==0){
            LinearLayoutManager manager = new LinearLayoutManager(context);
            manager.setOrientation(LinearLayoutManager.HORIZONTAL);
            holder.rv_adapter.setLayoutManager(manager);

            List<MyBean.ResultBean.PzshBean.CommodityListBeanX> pashlist=myBean.getResult().getPzsh().getCommodityList();
            PashAdapter pashAdapter=new PashAdapter(pashlist,context);
            holder.rv_adapter.setAdapter(pashAdapter);
        }else if (type==1){
            LinearLayoutManager manager = new LinearLayoutManager(context);
            manager.setOrientation(LinearLayoutManager.VERTICAL);
            holder.rv_adapter.setLayoutManager(manager);

            List<MyBean.ResultBean.RxxpBean.CommodityListBean> rxxplist=myBean.getResult().getRxxp().getCommodityList();
            RxxpAdapter rxxpAdapter=new RxxpAdapter(rxxplist,context);
            holder.rv_adapter.setAdapter(rxxpAdapter);
        }else if (type==2){
            GridLayoutManager manager=new GridLayoutManager(context,2);
            manager.setOrientation(LinearLayoutManager.VERTICAL);
            holder.rv_adapter.setLayoutManager(manager);

            List<MyBean.ResultBean.MlssBean.CommodityListBeanXX> mlsslist=myBean.getResult().getMlss().getCommodityList();
            MlshAdapter mlshAdapter=new MlshAdapter(mlsslist,context);
            holder.rv_adapter.setAdapter(mlshAdapter);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            type=0;
        }else if (position==1){
            type=1;
        }else if (position==2){
            type=2;
        }
        return type;
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class Holder extends RecyclerView.ViewHolder{

         RecyclerView rv_adapter;
        public Holder(@NonNull View itemView) {
            super(itemView);
            rv_adapter=itemView.findViewById(R.id.rv_adapter);
        }
    }

}
