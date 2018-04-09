package com.example.intentdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by _熊家路 on 2018/4/8.
 */

public class SActivty extends Activity {
    private Button bt1;
    private String content="这是第二个页面里数据";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sactivity);
        /*
         * 第二个页面给第一个回传数据
         * 回传到第一个页面的实际上是一个Intent对象
         */
        bt1=(Button)findViewById(R.id.SButton);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent data=new Intent();
                data.putExtra("data",content);
                setResult(2,data);
                finish();
            }
        });
    }
}
