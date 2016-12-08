package com.example.rens.rensvanderveldt_pset6;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AlarmView extends AppCompatActivity {

    public static final String MyPREFERENCES = "myprefs";
    SharedPreferences sharedpreferences;

    String username;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_view);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        username = sharedpreferences.getString("username",null);
        password = sharedpreferences.getString("password",null);

        // Authenticate user and get its data from database (location preferences).
        // Use data to populate listview

    }

    public void logOut(View view) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean("login", false);
        editor.putString("username", null);
        editor.putString("password", null);
        editor.apply();

        // Back to login screen
        Intent goToLogin = new Intent(this, LoginActivity.class);
        startActivity(goToLogin);
    }


    public void goToSettings(View view) {
        Intent goToSettings = new Intent(this, SettingsActivity.class);
    }
}
