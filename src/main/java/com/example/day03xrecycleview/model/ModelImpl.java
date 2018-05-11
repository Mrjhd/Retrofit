package com.example.day03xrecycleview.model;

import android.util.Log;

import com.example.day03xrecycleview.http.RetrofitUtiles;
import com.example.day03xrecycleview.presenter.IPresenter;

import java.util.Map;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 因为有个你i on 2018/5/11.
 */

public class ModelImpl implements IModel {
    private static final String TAG = "IModelImpl";
    private final IPresenter iPresenter;

    public ModelImpl(IPresenter iPresenter){
        this.iPresenter=iPresenter;
    }
    @Override
    public void getGoodsDate(Map<String, String> map) {
        RetrofitUtiles retrofitUtiles=RetrofitUtiles.getInstance();
        MyService myService = retrofitUtiles.createRequest(MyService.class);
        Observable<GoodsBean> observable = myService.getGoods(map);
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GoodsBean>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "完成");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "异常"+e.getMessage());
                    }

                    @Override
                    public void onNext(GoodsBean goodsBean) {
                        iPresenter.GetGoodsDate(goodsBean.getData());
                    }
                });

    }
//    @Override
//    public void getModelListener(String url, Map<String, String> map, final GoodsListener goodsListener) {
//        HttpUtils httpUtils=HttpUtils.getHttpUtils();
//        httpUtils.okPost(url,map);
//        httpUtils.setOkLoadListener(new OkLoadListener() {
//            @Override
//            public void okLoadSuccess(String json) {
//                goodsListener.getGoodsSuccess(json);
//            }
//
//            @Override
//            public void okLoadError(String error) {
//                goodsListener.getGoodsError(error);
//            }
//        });
//    }
}
