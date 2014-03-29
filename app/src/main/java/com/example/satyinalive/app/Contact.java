package com.example.satyinalive.app;

import android.graphics.Bitmap;

// Data object for the grid: a user or a group
public class Contact {
    public final String userID;
    public final Bitmap profilePic;

    public Contact(String userID, Bitmap profilePic) {
        this.userID = userID;
        this.profilePic = profilePic;
    }
}
