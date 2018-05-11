package com.example.day03xrecycleview.model;

/**
 * Created by 因为有个你i on 2018/5/11.
 */

public interface GoodsListener {
    void getGoodsSuccess(String json);
    void getGoodsError(String error);
}
