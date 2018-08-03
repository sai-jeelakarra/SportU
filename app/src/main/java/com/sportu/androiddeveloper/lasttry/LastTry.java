package com.sportu.androiddeveloper.lasttry;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

public class LastTry extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
