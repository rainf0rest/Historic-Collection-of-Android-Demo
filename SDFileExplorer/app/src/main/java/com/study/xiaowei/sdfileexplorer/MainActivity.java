package com.study.xiaowei.sdfileexplorer;

import android.app.Activity;;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends Activity {

    ListView listView;
    TextView textView;

    File currentParent;
    File[] currentFiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        listView = (ListView)findViewById(R.id.list);
        textView = (TextView)findViewById(R.id.path);

        final File root = new File("/mnt/sdcard/");

        if(root.exists()) {
            currentParent = root;
            currentFiles = root.listFiles();
            inflateListView(currentFiles);
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(currentFiles[position].isFile()) return;
                File[] tmp = currentFiles[position].listFiles();
                if(tmp == null || tmp.length == 0) {
                    Toast.makeText(MainActivity.this, "当前路径不可访问或该路径下没有文件", Toast.LENGTH_SHORT).show();
                }
                else {
                    currentParent = currentFiles[position];
                    currentFiles = tmp;
                    inflateListView(currentFiles);
                }
            }
        });

        Button parent = (Button)findViewById(R.id.parent);
        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (!currentParent.getCanonicalPath().equals("/mnt/sdcard")) {
                        currentParent = currentParent.getParentFile();
                        currentFiles = currentParent.listFiles();
                        inflateListView(currentFiles);
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    private void inflateListView(File[] files) {
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for(int i = 0; i < files.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            if(files[i].isDirectory()) {
                listItem.put("icon", R.drawable.files);
            }
            else{
                listItem.put("icon", R.drawable.file);
            }
            listItem.put("filename", files[i].getName());
            listItems.add(listItem);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems, R.layout.line, new String[]{"icon", "filename"},
        new int[]{R.id.icon, R.id.name});
        listView.setAdapter(simpleAdapter);
        try{
            textView.setText("当前路径:" + currentParent.getCanonicalPath());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
