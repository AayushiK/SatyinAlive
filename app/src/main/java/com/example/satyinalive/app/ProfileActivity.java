package com.example.satyinalive.app;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends Activity {

    private ImageView mProfileImage;
    private TextView mUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        mProfileImage = (ImageView) findViewById(R.id.profile_image);
        mUsername = (TextView) findViewById(R.id.username);
    }

}
