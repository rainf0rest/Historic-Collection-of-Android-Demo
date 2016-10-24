package com.study.xiaowei.myxx;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaowei on 2015/2/2.
 */
public class Txecent extends Activity {

    private String[] names = new String[]{
            "糖墨墨","雨上林空","长安李白","连城究","BYR","星空","樱花的飘落","巴黎的夜","爱上你的悲伤","绅士的凝视"
    };

    private String[] notes = new String[]{
            "我爱吃糖","80%","应劫的人生","每天都这么忙啊","矿工……","我的天空都是新星","我的雪呢？？？","浪漫即人生","伴你一世繁华","我不是好人哦"
    };
    private int[] images = new int[] {
           R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,
            R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher

           /* R.drawable.diyi,R.drawable.dier,R.drawable.disan,R.drawable.disi,R.drawable.diwu,R.drawable.diliu,
            R.drawable.diqi,R.drawable.diba,R.drawable.dijiu,R.drawable.dishi*/
    };
    @Override
    public void onCreate (Bundle savedInstanseState){
        super.onCreate(savedInstanseState);
        setContentView(R.layout.main);
        final TextView ps = (TextView) findViewById(R.id.Ps);
        List<Map<String, Object>> lists = new ArrayList<Map<String, Object>>();
        for(int i = 0; i<names.length; i++){
            Map<String, Object> list = new HashMap<String, Object>();
            list.put("header",images[i]);
            list.put("personName", names[i]);
            list.put("note",notes[i]);
            lists.add(list);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, lists, R.layout.simple,
                new String[]{"header","personName","note"},
                new int[]{R.id.header, R.id.personName,R.id.note});
        ListView listView = (ListView) findViewById(R.id.MyList);
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ps.setText(names[position] + ":How are you?"+"\n\nI :");
            }
        });
        /*listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ps.setText("Click  " + names[position] );
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/
    }

}
