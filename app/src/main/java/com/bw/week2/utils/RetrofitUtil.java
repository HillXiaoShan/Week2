package com.bw.week2.utils;

import com.bw.week2.api.API;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {

    private OkHttpClient okHttpClient;
    private Retrofit retrofit;

    public static RetrofitUtil util;
    private RetrofitUtil(){
        okHttpClient=new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .writeTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .build();

        retrofit=new Retrofit.Builder()
                .baseUrl(API.url)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }
    public static RetrofitUtil getInstance(){
        if (util==null){
            synchronized (RetrofitUtil.class){
                if (util==null){
                    util=new RetrofitUtil();
                }
            }
        }
        return  util;
    }

    public <T> T createService(Class<T> tClass){
        return retrofit.create(tClass);
    }

}
