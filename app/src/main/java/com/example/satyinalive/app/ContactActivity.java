package com.example.satyinalive.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by aayushi on 3/29/14.
 */
public class ContactActivity extends Activity implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        TextView name = (TextView) findViewById(R.id.username);
        name.setText("Aayushi");

    }

    @Override
    public void onClick(View v) {

    }
}
