package com.jing.demo.screeninfor;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * 描述: 辣度view
 * <p/>作者：景阳
 * <p/>创建时间: 2017/12/22 10:27
 */
public class PepperView extends LinearLayout {

    /**
     * 辣椒显示数量
     */
    private int pepperNum;

    /**
     * 辣椒最大数量
     */
    private int pepperNumMax;

    /**
     * 辣椒图片资源
     */
    private int pepperSrc;

    /**
     * 辣椒大小
     */
    private int itemWidth;

    public PepperView(Context context) {
        super(context);
    }

    public PepperView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public PepperView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.PepperView);
        pepperNum = a.getInteger(R.styleable.PepperView_pepperNum, 0);
        pepperNumMax = a.getInteger(R.styleable.PepperView_pepperNumMax, 0);
        pepperSrc = a.getResourceId(R.styleable.PepperView_pepperSrc, -1);
        itemWidth = a.getDimensionPixelSize(R.styleable.PepperView_itemWidth, 0);

        setOrientation(HORIZONTAL);
        for (int i = 0; i < pepperNumMax; i ++) {
            addPepper(i);
        }
    }

    private void addPepper(int position) {
        ImageView view = new ImageView(getContext());
        view.setLayoutParams(new ViewGroup.LayoutParams(itemWidth, itemWidth));
        if (pepperSrc != -1) {
            view.setImageResource(pepperSrc);
        }
        if (pepperNum < position) {
            view.setVisibility(VISIBLE);
        }
        else {
            view.setVisibility(GONE);
        }
        addView(view);
    }

    /**
     * 设置辣椒显示数量
     * @param num
     */
    public void setPepperLevel(int num) {
        if (num < pepperNumMax && num >= 0) {
            pepperNum = num;
            for (int i = 0; i < getChildCount(); i ++) {
                if (i < num) {
                    getChildAt(i).setVisibility(VISIBLE);
                }
                else {
                    getChildAt(i).setVisibility(GONE);
                }
            }
        }
    }

}
