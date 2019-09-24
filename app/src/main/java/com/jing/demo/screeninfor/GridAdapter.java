package com.jing.demo.screeninfor;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 描述:
 * <p/>作者：景阳
 * <p/>创建时间: 2018/1/17 14:52
 */
public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ItemHolder> {

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_buffet_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        Log.e("GridAdapter", "onBindViewHolder " + position);
        holder.tvName.setText("item" + position);
    }

    @Override
    public int getItemCount() {
        return 160;
    }

    public static class ItemHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_head)
        ImageView ivHead;
        @BindView(R.id.tv_number)
        TextView tvNumber;
        @BindView(R.id.tv_limit)
        TextView tvLimit;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.pepperView)
        PepperView pepperView;
        @BindView(R.id.tv_price)
        TextView tvPrice;
        @BindView(R.id.tv_name_eng)
        TextView tvNameEng;
        @BindView(R.id.tv_sold_out)
        TextView tvSoldOut;
        @BindView(R.id.group_card)
        ViewGroup groupCard;

        public ItemHolder(View itemView/*, int itemWidth, int itemHeight*/) {
            super(itemView);
            ButterKnife.bind(this, itemView);

//            ViewGroup.LayoutParams params = ivHead.getLayoutParams();
//            params.width = itemWidth;
//            params.height = itemWidth * 3 / 4;
//            ivHead.setLayoutParams(params);
//
//            params = groupCard.getLayoutParams();
//            params.width = itemWidth;
//            params.height = itemHeight;
//            groupCard.setLayoutParams(params);
        }
    }

}
