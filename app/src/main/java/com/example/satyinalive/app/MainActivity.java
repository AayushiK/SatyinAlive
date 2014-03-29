package com.example.satyinalive.app;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Contact> profiles = new ArrayList<Contact>(10);
        for (int i = 0; i<10; i++) {
            profiles.add(new Contact("10", null));
        }
        Adapter adapter = new Adapter(this);
        adapter.setContacts(profiles);
        GridView gridView = (GridView) findViewById(R.id.grid_view);
        gridView.setAdapter(adapter);
        Log.d("rawr", "workin");

        getActionBar().setDisplayHomeAsUpEnabled(false);
        getActionBar().setDisplayShowTitleEnabled(false);
        getActionBar().setDisplayUseLogoEnabled(false);
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
        } else if (id == R.id.action_create){
            createGroup();
            return true;
        } else if ((id == R.id.action_delete)) {

        }
        return super.onOptionsItemSelected(item);
    }

    public void createGroup() {
        Intent intent = new Intent(this, Group.class);
        startActivity(intent);
    }

}
