package com.study.xiaowei.mytextswitcher;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

/**
 * Created by xiaowei on 2015/2/3.
 */
public class MyTextSwitcher extends Activity {
    TextSwitcher textSwitcher;
    String[] strings = new String[]{
            "Android ser", "Android mer" , "Android ber", "Android ger"
    };
    int sount = 0;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        textSwitcher = (TextSwitcher) findViewById(R.id.TextSw);
        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(MyTextSwitcher.this);
                textView.setTextSize(40);
                textView.setTextColor(Color.BLACK);
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });
        next(null);
    }

    public void next(View source){
        textSwitcher.setText(strings[sount++ % strings.length]);
    }
}
