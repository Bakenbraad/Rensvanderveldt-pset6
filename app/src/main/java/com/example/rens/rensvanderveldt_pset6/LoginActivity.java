package com.example.rens.rensvanderveldt_pset6;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    public static final String MyPREFERENCES = "myprefs";
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // On creation remembrence must be turned off.
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean("login", false);
        editor.apply();
    }

    public void logIn(){
        EditText usernameET = (EditText) findViewById(R.id.loginUsername);
        EditText passwordET = (EditText) findViewById(R.id.loginPass);

        String username = usernameET.getText().toString();
        String password = passwordET.getText().toString();

        if (username.length() != 0){
            if (password.length() != 0){
                // TODO: authenticate user

                // Check for login remembrance.
                CheckBox memberBox = (CheckBox) findViewById(R.id.memberBox2);
                if (memberBox.isChecked()){
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putBoolean("login", true);
                    editor.putString("username", username);
                    editor.putString("password", password);
                    editor.apply();
                }

                Intent goToAlarmView = new Intent(this, AlarmView.class);
                startActivity(goToAlarmView);
            }
            else {
                Toast toast = Toast.makeText(this, "Vul uw wachtwoord in", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
        else {
            Toast toast = Toast.makeText(this, "Vul een naam in", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
