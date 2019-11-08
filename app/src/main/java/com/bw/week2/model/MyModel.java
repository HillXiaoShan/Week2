package com.bw.week2.model;

import com.bw.week2.bean.MyBean;
import com.bw.week2.contract.IContrract;
import com.bw.week2.utils.HomeService;
import com.bw.week2.utils.RetrofitUtil;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MyModel{

    public void getData(IContrract.CallBack callBack) {
        RetrofitUtil.getInstance().createService(HomeService.class).getmybean().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MyBean>() {
                    @Override
                    public void accept(MyBean myBean) throws Exception {
                        callBack.success(myBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        callBack.error("网络异常");
                    }
                });


    }
}
