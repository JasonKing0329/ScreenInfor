package com.jing.demo.screeninfor;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * <p/>作者： lxg
 * <p/>创建时间: 18/01/12 16:35.
 */

public abstract class GridViewPagerAdapter<T> extends PagerAdapter {

    private List<List<T>> mDataSource;

    private int rows = 1;
    private int columns = 1;

    public GridViewPagerAdapter(@NonNull List<List<T>> dataSource, int rows, int columns) {
//        ObjectHelper.requireNonNull(dataSource, "data source is null !");
//        ObjectHelper.verifyPositive(rows, "rows");
//        ObjectHelper.verifyPositive(columns, "columns");
        this.mDataSource = dataSource;
        this.rows = rows;
        this.columns = columns;
    }

    @Override
    public int getCount() {
        return 20;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        long time = System.currentTimeMillis();
        GridLayout gridLayout = new GridLayout(container.getContext());
        gridLayout.setLayoutParams(new ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT)
        );
        gridLayout.setRowColumn(rows, columns);
        for (int i = 0; i < 8; i ++) {
            gridLayout.addView(childView(i, gridLayout));
//                onBind(i, mDataSource.get(position).get(i));
        }
        container.addView(gridLayout);
        Log.e("GVPAdapter", "cost " + (System.currentTimeMillis() - time));
        return gridLayout;
    }

    @Override
    public int getItemPosition(Object object) {
        if (mDataSource != null && mDataSource.size() == 0) {
            return POSITION_NONE;
        }
        return super.getItemPosition(object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
     container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    public void setRowColumn(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    protected abstract View childView(int position, ViewGroup container);

    protected abstract void onBind(int position, T data);
}
