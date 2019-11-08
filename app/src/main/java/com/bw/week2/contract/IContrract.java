package com.bw.week2.contract;

import com.bw.week2.bean.MyBean;

public interface IContrract {
    interface IView{
        void success(MyBean myBean);
    }
    interface IPersent{
        void getData();
    }
    interface CallBack{
        void success(MyBean myBean);
        void error(String er);
    }
}
