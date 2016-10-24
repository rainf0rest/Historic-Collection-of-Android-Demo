package com.study.xiaowei.popupmenua;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupMenu;
import android.widget.Toast;

/**
 * Created by xiaowei on 2015/2/5.
 */
public class Popupa extends Activity {
    PopupMenu popup;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public void clickpup(View button){
        popup = new PopupMenu(this,button);
        getMenuInflater().inflate(R.menu.menu, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.aaa:
                        getWindow().setBackgroundDrawableResource(R.drawable.cc);
                        break;
                    case R.id.bbb:
                        getWindow().setBackgroundDrawableResource(R.drawable.bbb);
                        break;
                    case R.id.ccc:
                        getWindow().setBackgroundDrawableResource(R.drawable.ccc);
                        break;
                    default:
                        getWindow().setBackgroundDrawableResource(R.drawable.ic_launcher);
                        Toast.makeText(Popupa.this,"error",Toast.LENGTH_LONG).show();
                        break;
                }

                return true;
            }
        });
        popup.show();
    }
}
