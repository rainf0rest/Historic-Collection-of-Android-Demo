package com.study.xiaowei.funnypicture;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by xiaowei on 2015/2/17.
 */

public class Fun extends Activity {
    private Bitmap bitmap;
    @Override
    public void onCreate(Bundle savedInstancsState){
        super.onCreate(savedInstancsState);
        setContentView(new MyView(this,R.drawable.bb));
    }

    class MyView extends View {
        private final int WIDTH = 20;
        private final int HEIGHT = 20;
        private final int COUNT = (WIDTH +1)*(HEIGHT+1);
        private final float[] verts = new float[COUNT*2];
        private final float[] orig = new float[COUNT*2];
        public MyView(Context context, int drawableId){
            super(context);
            setFocusable(true);
            bitmap = BitmapFactory.decodeResource(getResources(),drawableId);
            float bitmapWidth = bitmap.getWidth();
            float bitmapHeight = bitmap.getHeight();
            int index = 0;
            for(int y = 0; y <= HEIGHT; y++){
                float fy = bitmapHeight * y / HEIGHT;
                for(int x = 0; x <=WIDTH; x++){
                    float fx = bitmapWidth * x /WIDTH;
                    orig[index*2 + 0] = verts[index*2 + 0] = fx;
                    orig[index*2 + 1] = verts[index*2 + 1] = fy;
                    index += 1;
                }
            }
            setBackgroundColor(Color.rgb(24,22,56));
        }
        @Override
        public void onDraw(Canvas canvas){
            canvas.drawBitmapMesh(bitmap, WIDTH, HEIGHT, verts, 0, null, 0, null);
        }
        public void warp(float cx, float cy){

            for(int i = 0; i < COUNT*2; i += 2){
                float dx = cx - orig[i+0];
                float dy = cy - orig[i+1];
                float dd = dx*dx + dy*dy;
                float d = (float) Math.sqrt(dd);
                float pull = 80000/((float)(dd*d));
                if(pull >= 1){
                    verts[i + 0] = cx;
                    verts[i + 1] = cy;
                }
                else{
                    verts[i + 0] = orig[i + 0] + dx*pull;
                    verts[i + 1] = orig[i + 1] + dy*pull;
                }
            }
            invalidate();
        }
        @Override
        public boolean onTouchEvent(MotionEvent event){
            warp(event.getX(), event.getY());
            return true;
        }
    }
}
