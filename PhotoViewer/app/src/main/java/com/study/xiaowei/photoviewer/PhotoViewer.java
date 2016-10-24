package com.study.xiaowei.photoviewer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioGroup;

/**
 * Created by xiaowei on 2015/2/2.
 */
public class PhotoViewer extends Activity {
    int[] images = new int[]{
            R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f,
            R.drawable.g, R.drawable.h, R.drawable.i, R.drawable.j, R.drawable.k, R.drawable.l
    };
    AdapterViewFlipper flipper ;

    @Override
    public void onCreate (Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.main);
        flipper = (AdapterViewFlipper) findViewById(R.id.Flipper);
        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return images.length;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView view = new ImageView(PhotoViewer.this);
                view.setImageResource(images[position]);
                view.setScaleType(ImageView.ScaleType.CENTER);
                view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
                return view;
            }
        };
        flipper.setAdapter(adapter);
    }

    public void pro (View source){
        flipper.showPrevious();
        flipper.stopFlipping();
    }

    public void next (View source){
        flipper.showNext();
        flipper.stopFlipping();
    }
}
