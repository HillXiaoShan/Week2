package com.bw.week2.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<P extends BasePersent> extends AppCompatActivity {

    public P p;

    private Unbinder unbinder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        unbinder= ButterKnife.bind(this);

        p=ProvidePersent();
        if (p!=null){
            p.attach(this);
        }
        initView();

        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int initLayout();
    protected abstract P ProvidePersent();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (p!=null){
            p.unattach();
            p=null;
        }
        if (unbinder!=null){
            unbinder=null;
        }
    }
}
