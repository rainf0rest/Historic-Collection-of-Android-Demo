package com.study.xiaowei.runball;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.os.Handler;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by xiaowei on 2015/2/16.
 */
public class MoveBack extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }

    class MyView extends View {
        final int BACK_HEIGHT = 1700;
        private Bitmap back;
        private Bitmap thing;
        final int WIDTH = 700;
        final int HEIGH = 940;
        private int startY = BACK_HEIGHT - HEIGH;

        public MyView(Context context){
            super(context);
            back = BitmapFactory.decodeResource(context.getResources(), R.drawable.cc);
            thing = BitmapFactory.decodeResource(context.getResources(),R.drawable.ic_launcher);
            final Handler handler = new Handler() {

                @Override
                public void handleMessage(Message message){
                    if(message.what==0x123){
                        if(startY <= 0){
                            startY = BACK_HEIGHT - HEIGH;

                        }
                        else{
                            startY -= 3;
                        }
                    }
                    invalidate();
                }

            };
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.sendEmptyMessage(0x123);
                }
            },0,100);
        }



        @Override
        public void onDraw (Canvas canvas){
            Bitmap temp = Bitmap.createBitmap(back, 0, startY, WIDTH, HEIGH);
            canvas.drawBitmap(temp, 0, 0, null);
            canvas.drawBitmap(thing, 160, 380, null);
        }
    }

}
