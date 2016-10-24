package com.study.xiaowei.handdraw;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by xiaowei on 2015/2/9.
 */
public class HandDriver extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.main);
        final HandDraw handDraw = new HandDraw(HandDriver.this,null);
        LinearLayout layout = (LinearLayout) findViewById(R.id.mainLayout);
        layout.addView(handDraw);
        handDraw.setBackgroundColor(Color.WHITE);
        Button eraser = (Button) findViewById(R.id.buttonOne);
        eraser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handDraw.paint.setColor(Color.WHITE);
                handDraw.paint.setStrokeWidth(10);
            }
        });
        Button paint = (Button) findViewById(R.id.buttonTwo);
        paint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handDraw.paint.setColor(Color.BLACK);
                handDraw.paint.setStrokeWidth(1);
            }
        });
        Button repaint = (Button) findViewById(R.id.buttonThree);
        repaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handDraw.paint.setColor(Color.WHITE);
                handDraw.paint.setStrokeWidth(600);
            }
        });
        Button color = (Button) findViewById(R.id.buttonFour);
        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int red = (int)(Math.random()*255);
                int green = (int)(Math.random()*255);
                int blue = (int)(Math.random()*255);
                handDraw.paint.setColor(Color.argb(255,red,green,blue));
            }
        });
    }
}
