package com.example.satyinalive.app;

import android.content.Context;
import android.graphics.BitmapFactory;
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
        ImageView image = new ImageView(mContext);
        image.setImageBitmap(BitmapFactory.decodeResource(
                mContext.getResources(),
                R.drawable.ic_launcher));
        //set onClickListener for image here to launch a new fragment.
        return image;
    }
}
