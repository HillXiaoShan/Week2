package com.bw.week2.present;

import com.bw.week2.MainActivity;
import com.bw.week2.base.BasePersent;
import com.bw.week2.bean.MyBean;
import com.bw.week2.contract.IContrract;
import com.bw.week2.model.MyModel;

public class MyPersent extends BasePersent implements IContrract.IPersent {
    MyModel myModel;
    public MyPersent(){
        myModel=new MyModel();
    }

    @Override
    public void getData() {
        myModel.getData(new IContrract.CallBack() {
            @Override
            public void success(MyBean myBean) {
                MainActivity mainActivity= (MainActivity) v;
                mainActivity.success(myBean);
            }

            @Override
            public void error(String er) {

            }
        });
    }
}
