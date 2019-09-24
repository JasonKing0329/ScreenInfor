package com.jing.demo.screeninfor;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
/**
 * 描述:
 * <p/>作者：景阳
 * <p/>创建时间: 2018/1/17 10:40
 */
public class ItemPageAdapter extends GridViewPagerAdapter<Object> {

    private ItemHolder holder;

    private List<Object> itemList;
    public ItemPageAdapter(@NonNull List<List<Object>> dataSource, int rows, int columns) {
        super(dataSource, rows, columns);
    }

    @Override
    protected View childView(int position, ViewGroup container) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.adapter_buffet_item, container, false);
        holder = new ItemHolder(view);
        return view;
    }

    @Override
    protected void onBind(int position, Object item) {
//        holder.tvName.setText(item.getName());
//        holder.tvNameEng.setText(item.getEngName());
//        holder.tvPrice.setText(item.getPrice());
//
//        Glide.with(holder.ivHead.getContext())
//                .load(item.getImagePath())
//                .apply(requestOptions)
//                .into(holder.ivHead);
//
//        ItemUpdator.with(lifecycle).load(item).onFinish(new ItemUpdator.FinishCallback() {
//            @Override
//            public void itemUpdated(ItemViewBean item) {
//                holder.tvSoldOut.setVisibility(item.isSoldOut() ? View.VISIBLE: View.GONE);
//
//                if (item.getLimit() >= 0) {
//                    holder.tvLimit.setText("限量" + FormatUtil.formatNumber(item.getLimit()));
//                    holder.tvLimit.setVisibility(View.VISIBLE);
//                }
//                else {
//                    holder.tvLimit.setVisibility(View.GONE);
//                }
//            }
//        });
//
//        double count = MemoryOrder.getInstance().getItemOrderCount(item.getBean().getItemId());
//        item.setCount(count);
//        if (count > 0) {
//            holder.tvNumber.setText(FormatUtil.formatNumber(count));
//            holder.tvNumber.setVisibility(View.VISIBLE);
//        }
//        else {
//            holder.tvNumber.setVisibility(View.GONE);
//        }
//
//        if (item.getBean().getPungencyDegree() > 0) {
//            holder.pepperView.setPepperLevel(item.getBean().getPungencyDegree());
//        }
//        else {
//            holder.pepperView.setPepperLevel(0);
//        }
//
////        holder.groupCard.setTag(position);
////        holder.groupCard.setOnClickListener(this);
    }

    public static class ItemHolder {

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
