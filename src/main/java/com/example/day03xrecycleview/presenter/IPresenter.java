package com.example.day03xrecycleview.presenter;

import com.example.day03xrecycleview.model.GoodsBean;
import com.example.day03xrecycleview.model.IModel;
import com.example.day03xrecycleview.view.IMainView;

import java.util.List;

/**
 * Created by 因为有个你i on 2018/5/11.
 */

public interface IPresenter {
    void showPresenter(IModel iModel, IMainView iMainView);
    void GetGoodsDate(List<GoodsBean.DataBean> data);
}
