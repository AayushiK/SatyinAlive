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

import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.Settings;
import com.facebook.UiLifecycleHelper;
import com.facebook.model.GraphUser;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private UiLifecycleHelper uiHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        uiHelper = new UiLifecycleHelper(this, callback);
        uiHelper.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ArrayList<Contact> profiles = new ArrayList<Contact>(20);

        profiles.add(new Contact("667315466", "http://i.imgur.com/DvpvklR.png", "Zon Lai"));
        profiles.add(new Contact("1000361", "https://fbcdn-profile-a.akamaihd.net/hprofile-ak-prn1/t1.0-1/c12.12.155.155/12471_10153275341671515_1307579091_a.jpg", "Fred Muriano"));
        profiles.add(new Contact("1106769", "https://fbcdn-profile-a.akamaihd.net/hprofile-ak-prn2/t1.0-1/c35.0.160.160/p160x160/1898084_233907656793488_1264213250_n.jpg", "Aayushi Kaushik"));
        profiles.add(new Contact("1106769", "https://fbcdn-profile-a.akamaihd.net/hprofile-ak-prn2/t1.0-1/c35.0.160.160/p160x160/1898084_233907656793488_1264213250_n.jpg", "Aayushi Kaushik"));


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

    private void onSessionStateChange(Session session, SessionState state, Exception exception) {
        if (state.isOpened()) {
            Log.i(TAG, "Logged in...");
            fetchFriends(session);

        } else if (state.isClosed()) {
            Log.i(TAG, "Logged out...");
        }
    }

    private Session.StatusCallback callback = new Session.StatusCallback() {
        @Override
        public void call(Session session, SessionState state, Exception exception) {
            onSessionStateChange(session, state, exception);
        }
    };

    @Override
    public void onResume() {
        super.onResume();
        uiHelper.onResume();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        uiHelper.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onPause() {
        super.onPause();
        uiHelper.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        uiHelper.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        uiHelper.onSaveInstanceState(outState);
    }

    public void createGroup() {
        Intent intent = new Intent(this, Group.class);
        startActivity(intent);
    }

    private void testFB() {
        Settings.addLoggingBehavior(LoggingBehavior.INCLUDE_ACCESS_TOKENS);
        Settings.addLoggingBehavior(LoggingBehavior.REQUESTS);

        Request request = Request.newGraphPathRequest(null, "/4", new Request.Callback() {
            @Override
            public void onCompleted(Response response) {
                if(response.getError() != null) {
                    Log.i("MainActivity", String.format("Error making request: %s", response.getError()));
                } else {
                    GraphUser user = response.getGraphObjectAs(GraphUser.class);
                    Log.i("MainActivity", String.format("Name: %s", user.getName()));
                }
            }
        });
        request.executeAsync();
    }

    private void fetchFriends(Session session) {
        Log.e("SMR", "fetchFriends");

        Bundle params = new Bundle();
        params.putString("fields", "friends.fields(name,id,picture.type(normal))");

        /* make the API call */
        new Request(
                session,
                "/me",
                params,
                HttpMethod.GET,
                new Request.Callback() {
                    public void onCompleted(Response response) {
                        Log.e("SMR", response.toString());
                        if(response.getError() != null ) {
                            Log.e("SMR", "Error");
                        } else {
                            JSONObject jsonObject = response.getGraphObject().getInnerJSONObject();
                            Log.d("SMR", jsonObject.toString());
                        }
                    }
                }
        ).executeAsync();
    }

}
