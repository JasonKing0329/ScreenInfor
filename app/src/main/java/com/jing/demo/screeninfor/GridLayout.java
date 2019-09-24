package com.jing.demo.screeninfor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * <p/>作者： lxg
 * <p/>创建时间: 18/01/15 9:20.
 */

public class GridLayout extends ViewGroup {

    private int rows = 1;
    private int columns = 1;

    public GridLayout(Context context) {
        super(context);
    }

    public GridLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GridLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setRowColumn(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        // wrap_content
        int width = 0;
        int height = 0;

        int lineWidth = 0;
        int lineHeight = 0;

        int indexWidth = 0;
        int indexHeight = 0;

        int cCount = getChildCount();

        for (int i = 0; i < cCount; i++) {
            View child = getChildAt(i);
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
            int childWidth = child.getMeasuredWidth() + lp.leftMargin
                    + lp.rightMargin;
            int childHeight = child.getMeasuredHeight() + lp.topMargin
                    + lp.bottomMargin;

            if (++indexWidth == rows) {
                width = Math.max(lineWidth, width);
                height = height + lineHeight;
                indexWidth = 0;
                indexHeight++;
            } else {
                lineHeight = Math.max(lineHeight, childHeight);
                lineWidth = lineWidth + childWidth;
            }

            if (i == cCount - 1 && indexWidth != rows) {
                height += lineHeight;
                width = Math.max(lineWidth, width);
            }
        }

        setMeasuredDimension(
                widthMode == MeasureSpec.EXACTLY ? widthSize : width + getPaddingLeft() + getPaddingRight(),
                heightMode == MeasureSpec.EXACTLY ? heightSize : height + getPaddingTop() + getPaddingBottom()
        );
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int cCount = getChildCount();

        //获取每个childView的平均宽高
        int itemWidth = getWidth() / columns;
        int itemHeight = getHeight() / rows;
        int viewIndex = 0;

        int top = getPaddingTop();
        for (int j = 0; j < rows; j++) {
            int left = getPaddingLeft();
            for (int k = 0; k < columns; k++) {

                if (viewIndex >= cCount) {
                    break;
                }

                View child = getChildAt(viewIndex++);
                MarginLayoutParams lp = (MarginLayoutParams) child
                        .getLayoutParams();
                int lc = left + lp.leftMargin;
                int tc = top + lp.topMargin;
                int rc = lc + Math.min(child.getMeasuredWidth(), itemWidth - lp.leftMargin - lp.rightMargin);
                int bc = tc + Math.min(child.getMeasuredHeight(), itemHeight - lp.topMargin - lp.bottomMargin);
                child.layout(lc, tc, rc, bc);
                left += itemWidth;
            }
            top += itemHeight;
        }
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new MarginLayoutParams(p);
    }

}
