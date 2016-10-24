package com.study.xiaowei.guessnumber11;

/**
 * Created by xiaowei on 2015/2/1.
 */


        import android.app.Activity;
        import android.os.Bundle;
        import android.view.KeyEvent;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.GridLayout;
        import android.widget.LinearLayout;
        import android.widget.RadioGroup;
        import android.widget.TextView;
        import android.widget.Toast;


public class GuessNumber extends Activity{
    int level = 1;
    int max = 10;
    int randomNum = (int)(Math.random()*max);
    int times = 0;
    int sco = 0;
    int number = 0;
    int maxTimes = level*2 +3;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);
        //LinearLayout back = (LinearLayout) findViewById(R.id.root);
        final TextView help = (TextView) findViewById(R.id.Help);
        help.setText("The number is 0 ~ " + max + "\nscore : " + sco +"\nYou can guess " +(maxTimes-times) + " times!");
        final TextView textView = (TextView) findViewById(R.id.ps);

        final TextView look =(TextView) findViewById(R.id.Look);
        look.setText(R.string.guess_me);

        Button again = (Button) findViewById(R.id.button);
        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomNum = (int)(Math.random()*max);
                textView.setText(R.string.ps);
                times = 0;
                number = 0;
                help.setText("The number is 0 ~ " + max + "\nscore : " + sco + "\nYou can guess " +(maxTimes-times) + " times!");
            }
        });

        RadioGroup rg = (RadioGroup) findViewById(R.id.group);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.levelOne){
                    max = 10;
                    level= 1;
                }

                else if(checkedId == R.id.levelTwo){
                    max = 100;
                    level= 2 ;
                }

                else if(checkedId == R.id.levelThree){
                    max =1000;
                    level = 3;
                }

                else if(checkedId == R.id.levelFour){
                    max = 10000;
                    level = 4;
                }
        times = 0;
                maxTimes = level*2 + 3;
                help.setText("The number is 0 ~ " + max + "\nscore : " + sco  + "\nYou can guess " +(maxTimes-times) + " times!");

            }
        });


        Button one = (Button) findViewById(R.id.One);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number=number*10+1;
                look.setText(""+number);
            }
        });

        Button two = (Button) findViewById(R.id.Two);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number=number*10+2;
                look.setText(""+number);
            }
        });

        Button three = (Button) findViewById(R.id.Three);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number=number*10+3;
                look.setText(""+number);
            }
        });

        Button four = (Button) findViewById(R.id.Four);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = number * 10 + 4;
                look.setText("" + number);
            }
        });

        Button five = (Button) findViewById(R.id.Five);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = number * 10 + 5;
                look.setText("" + number);
            }
        });

        Button six = (Button) findViewById(R.id.Six);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = number * 10 + 6;
                look.setText("" + number);
            }
        });

        Button seven = (Button) findViewById(R.id.Seven);
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number=number*10+7;
                look.setText(""+number);
            }
        });

        Button eight = (Button) findViewById(R.id.Eight);
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = number * 10 + 8;
                look.setText("" + number);
            }
        });

        Button nine = (Button) findViewById(R.id.Nine);
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number=number*10+9;
                look.setText(""+number);
            }
        });

        Button zero = (Button) findViewById(R.id.Zero);
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number=number*10+0;
                look.setText(""+number);
            }
        });

        Button back = (Button) findViewById(R.id.Back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number=number/10;
                look.setText(""+number);
            }
        });

        Button enter = (Button) findViewById(R.id.Enter);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++times;

                if(times > maxTimes){
                    if(times == maxTimes +1) {
                        sco--;
                        textView.setText("You lose! Too many guess times!");
                    }
                }

                else {
                    if (randomNum < number) {
                        textView.setText("too big");

                    } else if (randomNum > number) {
                        textView.setText("too small");
                    } else{
                        textView.setText("yes! It's " + randomNum);
                        sco= sco + ant(level,level);
                    }
                    help.setText("The number is 0 ~ " + max + "\nscore : " + sco+ "\nYou can guess " +(maxTimes-times) + " times!");
                }
                number = 0;

            }

            public int ant (int x , int y){
                int s = 1;
                for(;y>0;y--)
                    s=s*x;
                return s;
            }
        });


    }
}
