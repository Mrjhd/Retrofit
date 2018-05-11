package com.example.day03xrecycleview.presenter;

import com.example.day03xrecycleview.model.GoodsBean;
import com.example.day03xrecycleview.model.IModel;
import com.example.day03xrecycleview.view.IMainView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 因为有个你i on 2018/5/11.
 */

public class PresenterImpl implements IPresenter {
    private IMainView iMainView;
    @Override
    public void showPresenter(IModel iModel, final IMainView iMainView) {
        this.iMainView=iMainView;
        Map<String,String> map=new HashMap<>();
        map.put("pscid",iMainView.pscid()+"");
//        iModel.getModelListener(HttpConfig.goods_url, map, new GoodsListener() {
//            @Override
//            public void getGoodsSuccess(String json) {
//                Gson gson=new Gson();
//                GoodsBean goodsBean=gson.fromJson(json, GoodsBean.class);
//                List<GoodsBean.DataBean> list=goodsBean.getData();
//                iMainView.showGoods(list);
//            }
//
//            @Override
//            public void getGoodsError(String error) {
//
//            }
//        });
        iModel.getGoodsDate(map);
    }

    @Override
    public void GetGoodsDate(List<GoodsBean.DataBean> data) {
        iMainView.showGoods(data);
    }


}
