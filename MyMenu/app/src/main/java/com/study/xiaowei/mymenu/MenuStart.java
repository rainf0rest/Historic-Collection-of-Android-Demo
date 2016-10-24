package com.study.xiaowei.mymenu;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by xiaowei on 2015/2/5.
 */
public class MenuStart extends Activity {
    private TextView txt;
    private PopupMenu popup;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        txt = (TextView) findViewById(R.id.textView);
        registerForContextMenu(txt);


    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View source, ContextMenu.ContextMenuInfo menuInfo){
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu,menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem mi){

        mi.setChecked(true);

        switch(mi.getItemId()){
            case R.id.Simple:
                txt.setText(R.string.simple);
                break;
            case R.id.Middle:
                txt.setText(R.string.middle);
                break;
            case R.id.Difficult:
                txt.setText(R.string.difficult);
                break;
            default:
                txt.setText("selecting...");
                break;
        }
        return true;
    }


}
