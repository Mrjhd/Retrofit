package com.example.day03xrecycleview.view;

import com.example.day03xrecycleview.model.GoodsBean;

import java.util.List;

/**
 * Created by 因为有个你i on 2018/5/11.
 */

public interface IMainView {
    void showGoods(List<GoodsBean.DataBean> list);
    int pscid();
}
