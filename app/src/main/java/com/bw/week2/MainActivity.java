package com.bw.week2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.bw.week2.adapter.MyRvAdapter;
import com.bw.week2.base.BaseActivity;
import com.bw.week2.base.BasePersent;
import com.bw.week2.bean.MyBean;
import com.bw.week2.contract.IContrract;
import com.bw.week2.present.MyPersent;

import static androidx.recyclerview.widget.LinearLayoutManager.VERTICAL;

public class MainActivity extends BaseActivity implements IContrract.IView {


    private RecyclerView rv;

    @Override
    protected void initData() {
        MyPersent myPersent= (MyPersent) p;
        myPersent.getData();
    }

    @Override
    protected void initView() {
        rv = findViewById(R.id.rv);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(VERTICAL);
        rv.setLayoutManager(manager);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePersent ProvidePersent() {
        return new MyPersent();
    }

    @Override
    public void success(MyBean myBean) {
        MyRvAdapter myRvAdapter = new MyRvAdapter(myBean,this);
        rv.setAdapter(myRvAdapter);
    }
}
