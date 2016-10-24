package com.study.xiaowei.smallball;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by xiaowei on 2015/1/30.
 */
public class CustomView extends Activity{
    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        LinearLayout root = (LinearLayout)findViewById(R.id.root);
        final DrawView draw = new DrawView(this);
        draw.setMinimumWidth(300);
        draw.setMinimumHeight(500);
        /*Toast tt = Toast.makeText(CustomView.this, "tuoch and paint!",Toast.LENGTH_SHORT);
        tt.setGravity(Gravity.CENTER,10,10);
        tt.show();*/
        Toast toast =new Toast(CustomView.this);
        toast.setGravity(Gravity.CENTER,60,60);
        LinearLayout layout = new LinearLayout(CustomView.this);
        ImageView imageView =new ImageView(CustomView.this);
        TextView textView =new TextView(CustomView.this);
        layout.setOrientation(LinearLayout.VERTICAL);
        imageView.setImageResource(R.drawable.pp);
        textView.setText("Where you tuoch, where the small ball go!");
        textView.setTextSize(40);
        textView.setTextColor(Color.CYAN);
        layout.addView(textView);
        layout.addView(imageView);
        toast.setView(layout);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();

        root.addView(draw);
    }
}
