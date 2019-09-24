package com.jing.demo.screeninfor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GridActivity extends AppCompatActivity {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    private PagingScrollHelper pagingScrollHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        ButterKnife.bind(this);

        GridLayoutManager manager = new GridLayoutManager(this, 2);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerview.setLayoutManager(manager);

        pagingScrollHelper = new PagingScrollHelper();
        pagingScrollHelper.setUpRecycleView(recyclerview);

        recyclerview.setAdapter(new GridAdapter());
    }

    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                pagingScrollHelper.setPage(0);
                break;
            case R.id.btn2:
                pagingScrollHelper.setPage(8);
                break;
            case R.id.btn3:
                pagingScrollHelper.setPage(12);
                break;
            case R.id.btn4:
                pagingScrollHelper.setPage(16);
                break;
        }
    }
}
