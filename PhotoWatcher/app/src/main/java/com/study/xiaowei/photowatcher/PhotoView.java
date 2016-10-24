package com.study.xiaowei.photowatcher;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by xiaowei on 2015/1/30.
 */
public class PhotoView extends Activity {

    int[] images = new int[] {
            R.drawable.flower,
            R.drawable.li,
            R.drawable.shishi,
    };
    int currentImage = 0;
        @Override
        public void onCreate (Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);
            LinearLayout main = (LinearLayout) findViewById(R.id.root);
            final ImageView image = new ImageView(this);
            main.addView(image);
            image.setImageResource(images[0]);
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    image.setImageResource(images[++currentImage % images.length]);
                }
            });
        }
}
