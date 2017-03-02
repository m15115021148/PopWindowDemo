package com.geek.popwindowdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.security.MessageDigest;
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
        Log.e("result",MD5("123456"));
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

    /**
     * MD5加密，32位
     * @param str
     * @return
     */
    public static String MD5(String str) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

        char[] charArray = str.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            byteArray[i] = (byte) charArray[i];
        }
        byte[] md5Bytes = md5.digest(byteArray);

        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString().toUpperCase();
    }
}
