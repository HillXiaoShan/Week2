package com.bw.week2.base;

public class BasePersent<V extends BaseActivity> {
    public V v;

    public void attach(V v){
        this.v=v;
    }

    public void unattach(){
        if (v!=null){
            v=null;
        }
    }
}
