package com.study.xiaowei.chronometer;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

/**
 * Created by xiaowei on 2015/2/2.
 */

public class MyChronometer extends Activity{
    Chronometer clock;
    Button begin;
    int temp = 0;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        clock = (Chronometer) findViewById(R.id.Clock);
        begin = (Button) findViewById(R.id.Begin);

        begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(temp == 0){
                    clock.setBase(SystemClock.elapsedRealtime());
                    clock.start();
                    temp = 1;
                    begin.setText("End");
                }
                else{
                    clock.stop();
                    begin.setText("Start");
                    temp = 0;
                }
            }
        });

       /* clock.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if(SystemClock.elapsedRealtime() - clock.getBase() >20*1000){
                    clock.stop();
                    begin.setEnabled(true);
                }
            }
        });*/
    }

}
