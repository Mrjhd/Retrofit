package com.example.day03xrecycleview.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.example.day03xrecycleview.R;
import com.example.day03xrecycleview.model.GoodsBean;
import com.example.day03xrecycleview.model.ModelImpl;
import com.example.day03xrecycleview.adapter.MyAdapter;
import com.example.day03xrecycleview.presenter.PresenterImpl;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IMainView{

    @BindView(R.id.xrecycleview)
    XRecyclerView xrecycleview;
    int pscid=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initViews();
        initDatas();


    }

    private void initDatas() {
        PresenterImpl presenter=new PresenterImpl();
        presenter.showPresenter(new ModelImpl(),this);
    }

    private void initViews() {
        xrecycleview.setLayoutManager(new LinearLayoutManager(this));
        xrecycleview.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

                xrecycleview.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                PresenterImpl presenter=new PresenterImpl();
                presenter.showPresenter(new ModelImpl(),MainActivity.this);
                xrecycleview.refreshComplete();
            }
        });
    }

    @Override
    public void showGoods(List<GoodsBean.DataBean> list) {

        MyAdapter adapter=new MyAdapter(this,list);
        xrecycleview.setAdapter(adapter);
    }

    @Override
    public int pscid() {
        return pscid++;
    }
}
