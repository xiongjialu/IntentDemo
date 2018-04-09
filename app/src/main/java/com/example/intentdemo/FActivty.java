package com.example.intentdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by _熊家路 on 2018/4/8.
 */

public class FActivty extends Activity {
    private Button bt1;
    private Button bt2;
    private Context mContext;  //全局变量
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.factivity);
         /*
          * startActivity方式实现
          */
        bt1=(Button)findViewById(R.id.Button1);
        bt2=(Button)findViewById(R.id.Button2);
        textView=(TextView)findViewById(R.id.textView1);

        //注册点击事件
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                 * 第一个参数 上下文对象this
                  * 第二个参数 目标文件
                 */
                Intent intent=new Intent(FActivty.this,SActivty.class);  // 第一个参数 上下文对象this
               // Intent intent=new Intent(mContext,SActivty.class);       //第二个参数 目标文件
                startActivity(intent);      //无返回值的第一种方式
            }
        });

        /*
         * 第二种方式 又返回数据
         */
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FActivty.this,SActivty.class);

                /**
                 * 第一个参数是Intent对象
                 * 第二个是请求的一个标识
                 */
                startActivityForResult(intent,1);

            }
        });

    }

    /**
     * 通过onActivityResult 跳转 接受返回数据方法
     * requestCode：请求的标识
     * resultCode：第二个页面返回的标识
     * data ：第二个页面回传的数据
     * 去SActivity写相关代码
     *
     *
     * onActivityResult(int requestCode, int resultCode, Intent data)
       第一个参数：这个整数requestCode提供给onActivityResult，是以便确认返回的数据是从哪个Activity返回的。
       这个requestCode和startActivityForResult中的requestCode相对应。
       第二个参数：这整数resultCode是由子Activity通过其setResult()方法返回。
       第三个参数：一个Intent对象，带有返回的数据。
     *
     */

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1&&resultCode==2) {
            String content=data.getStringExtra("data");
            textView.setText(content);
        }
    }
}
