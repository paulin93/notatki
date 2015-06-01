package com.example.pinka.notatki;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;


public class DodajNotatkeActivity extends ActionBarActivity {

    EditText editText= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_notatke);
        editText=(EditText)findViewById(R.id.editText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dodaj_notatke, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_save) {
            if (!editText.getText().toString().equals("")){
                Intent intent= new Intent();
                intent.putExtra("notatka",editText.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
            else {
                Toast.makeText(getApplicationContext(),"Wpisz aby zapisac",Toast.LENGTH_SHORT).show();
            }

        }

        return super.onOptionsItemSelected(item);
    }
}
