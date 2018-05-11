package com.example.day03xrecycleview.model;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by 因为有个你i on 2018/5/11.
 */

public interface MyService {
    @GET("product/getProducts")
    Observable<GoodsBean> getGoods(@QueryMap Map<String,String> map);
}
