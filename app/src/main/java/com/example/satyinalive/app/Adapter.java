package com.example.satyinalive.app;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by aayushi on 3/29/14.
 */
public class Adapter extends BaseAdapter{

    private Context mContext;
    private List<Contact> mContacts;

    public Adapter(Context context) {
        mContext = context;
    }

    public void setContacts(List<Contact> contacts) {
        mContacts = contacts;
    }

    @Override
    public int getCount() {
        return mContacts.size();
    }

    @Override
    public Object getItem(int i) {
        return mContacts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final int index = i;
        ImageView image = new ImageView(mContext);
        image.setImageBitmap(BitmapFactory.decodeResource(
                mContext.getResources(),
                R.drawable.profile));
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(mContext, ContactActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString(ContactConstants.ARG_CONTACT_ID, mContacts.get(index).userID);
                bundle.putString(ContactConstants.ARG_CONTACT_NAME, mContacts.get(index).name);
                mainIntent.putExtras(bundle);
                mContext.startActivity(mainIntent);
            }
        });
        image.setPadding(10, 10, 10, 10);
        //set onClickListener for image here to launch a new fragment.
        return image;
    }
}
