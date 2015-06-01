package com.example.pinka.notatki;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    ListView lv= null;
    ArrayAdapter<String> adapter= null;
    List<String> list= null;
    int pozycja= -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        lv=(ListView)findViewById(R.id.listView);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                pozycja=position;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_new) {
            Intent intent=new Intent(getApplicationContext(),DodajNotatkeActivity.class);
            startActivityForResult(intent,1);
        }
        else if (id == R.id.action_delete) {
            if (pozycja!=-1) {
                list.remove(pozycja);
                adapter.notifyDataSetChanged();
            }
            else {
                Toast.makeText(getApplicationContext(),"klijnij na liscie",Toast.LENGTH_SHORT).show();
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int RequestCode, int ResultCode, Intent Data){
        if (RequestCode==1){
            String notatka= Data.getStringExtra("notatka"); //zapisuje
            list.add(notatka);
            adapter.notifyDataSetChanged();
        }
    }


}
