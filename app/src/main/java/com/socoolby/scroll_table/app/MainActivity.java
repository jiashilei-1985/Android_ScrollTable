package com.socoolby.scroll_table.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.socoolby.scroll_table.lib.ScrollTableView;


public class MainActivity extends ActionBarActivity {
    ScrollTableView stv_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stv_main=(ScrollTableView)findViewById(R.id.stv_main);
        int count=10;
        String []title_horizontal=new String[count];
        String []title_vertical=new String[count];
        String [][]content=new String[count][count];
        for(int i=0;i<count;i++) {
            title_vertical[i] = i+"";
            for (int j = 0; j < count; j++) {
                content[i][j] = i + " " + j;

            }
            title_horizontal[i]=i+"";
        }

        stv_main.setData(title_horizontal,title_vertical,content);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
