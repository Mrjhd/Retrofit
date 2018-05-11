package com.example.day03xrecycleview.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.day03xrecycleview.R;
import com.example.day03xrecycleview.model.GoodsBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * Created by 因为有个你i on 2018/5/11.
 */

public class MyAdapter extends XRecyclerView.Adapter<XRecyclerView.ViewHolder>{
    private static final int TYPE0 = 0;
    private static final int TYPE1 = 1;
    private Context context;
    private List<GoodsBean.DataBean> list;

    public MyAdapter(Context context, List<GoodsBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==TYPE0){

            View view=View.inflate(context, R.layout.layout_item1,null);
            MyViewHodel myViewHodel=new MyViewHodel(view);
            return myViewHodel;
        }else if (viewType==TYPE1){
            View view=View.inflate(context,R.layout.layout_item2,null);
            MyPicHodel picHodel=new MyPicHodel(view);
            return picHodel;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof MyViewHodel){
            MyViewHodel myViewHodel= (MyViewHodel) holder;
            String images=list.get(position).getImages();
            String img=images.split("\\|")[0];
            Uri uri= Uri.parse(img);
            myViewHodel.img.setImageURI(uri);
            myViewHodel.price01.setText(list.get(position).getTitle());
            myViewHodel.price02.setText("￥"+list.get(position).getPrice());
        }else if (holder instanceof MyPicHodel){
            MyPicHodel myPicHodel= (MyPicHodel) holder;
            String images=list.get(position).getImages();
            String img=images.split("\\|")[0];
            Uri uri= Uri.parse(img);
            myPicHodel.item02_img.setImageURI(uri);
            myPicHodel.item02_price01.setText(list.get(position).getTitle());
            myPicHodel.item02_price02.setText("￥"+list.get(position).getPrice());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position%2==0){

            return TYPE0;
        }else {
            return TYPE1;

        }
    }

    public class MyViewHodel extends XRecyclerView.ViewHolder{

        private final SimpleDraweeView img;
        private final TextView price01;
        private final TextView price02;


        public MyViewHodel(View itemView) {

            super(itemView);
            img = itemView.findViewById(R.id.img);
            price01 = itemView.findViewById(R.id.price01);
            price02 = itemView.findViewById(R.id.price02);
        }
        public SimpleDraweeView getImg() {
            return img;
        }

        public TextView getPrice01() {
            return price01;
        }

        public TextView getPrice02() {
            return price02;
        }
    }

    private class MyPicHodel extends XRecyclerView.ViewHolder{
        private final SimpleDraweeView item02_img;
        private final TextView item02_price01;
        private final TextView item02_price02;
        public MyPicHodel(View itemView) {
            super(itemView);
            item02_img = itemView.findViewById(R.id.item02_img);
            item02_price01 = itemView.findViewById(R.id.item02_price01);
            item02_price02 = itemView.findViewById(R.id.item02_price02);
        }

        public SimpleDraweeView getItem02_img() {
            return item02_img;
        }

        public TextView getItem02_price01() {
            return item02_price01;
        }

        public TextView getItem02_price02() {
            return item02_price02;
        }
    }
}
