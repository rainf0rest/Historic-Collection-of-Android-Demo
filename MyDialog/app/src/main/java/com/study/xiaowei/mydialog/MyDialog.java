package com.study.xiaowei.mydialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by xiaowei on 2015/2/4.
 */
public class MyDialog extends Activity {
    LinearLayout shows;
    String[] items;
    TextView showers;
    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        shows = (LinearLayout) findViewById(R.id.layout);
        getWindow().setBackgroundDrawableResource(R.drawable.bb);
        Resources res = getResources();
        items = res.getStringArray(R.array.bia);
        showers = (TextView) findViewById(R.id.shower);
        //Button Db = (Button) findViewById(R.id.button);

    }

    public void show(View source){
        AlertDialog.Builder builder = new AlertDialog.Builder(this).setTitle("The first choice:")
                .setIcon(R.drawable.dd)
                .setSingleChoiceItems(items,0,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        showers.setText("The choice is " + items[which] );
                    }
                });
                setPositiveButton(builder);
                setNegativeButton(builder).create()
                .show();
    }

    private AlertDialog.Builder setPositiveButton(AlertDialog.Builder builder){
        return builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                getWindow().setBackgroundDrawableResource(R.drawable.nn);
            }
        });
    }

    private AlertDialog.Builder setNegativeButton(AlertDialog.Builder builder){
        return builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                getWindow().setBackgroundDrawableResource(R.drawable.bb);
            }
        });
    }
}
