package com.bw.week2.utils;

import com.bw.week2.bean.MyBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface HomeService {
    @GET("small/commodity/v1/commodityList")
    Observable<MyBean> getmybean();
}
