package com.jing.demo.screeninfor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import cn.com.tcsl.screenhelper.ScreenUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.screen_text);
        textView.setText(ScreenUtil.getScreenInfor(this) + "\n"
            + "Real res: " + getString(R.string.sw_info));

    }
}
