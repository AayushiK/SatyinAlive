package com.example.satyinalive.app;D/

import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

        ImageView sendOK = (ImageView) findViewById(R.id.send_ok);
        sendOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("fb://messaging/{user_id}")));
            }
        });

    }

    @Override
    public void onClick(View v) {

    }
}
