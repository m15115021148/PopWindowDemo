package com.geek.popwindowdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.Arrays;

public class TestActivity extends AppCompatActivity implements CustomPopView.OnItemListener{
    private TestActivity mContext;
    private CustomPopView popView;
    private String[] key = {"拍照","相册","相册1","相册2","相册3","相册4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mContext = this;
        popView = new CustomPopView(this, Arrays.asList(key),this);
    }

    public void onShow(View view) {
        popView.showBottom();
    }

    @Override
    public void onClick(String values) {
        if (values.equals(key[0])){
            Toast.makeText(mContext,values,Toast.LENGTH_SHORT).show();
            popView.dismiss();
        }
        if (values.equals(key[1])){
            Toast.makeText(mContext,values,Toast.LENGTH_SHORT).show();
            popView.dismiss();
        }
    }

    public void onTop(View view) {
        popView.showTop();
    }

    public void onLeft(View view) {
        popView.showLeft();
    }

    public void onRight(View view) {
        popView.showRight();
    }
}
