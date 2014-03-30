package com.example.satyinalive.app;

import android.graphics.Bitmap;

// Data object for the grid: a user or a group
public class Contact {
    public final String userID;
    public final String url;
    public final String name;

    public Contact(String userID, String url, String name) {
        this.userID = userID;
        this.url = url;
        this.name = name;
    }
}
