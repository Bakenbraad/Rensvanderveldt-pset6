package com.example.rens.rensvanderveldt_pset6;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public static final String MyPREFERENCES = "myprefs";
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check for login remembrance.
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        if (sharedpreferences.getBoolean("login", false)){
            forward();
            finish();
        }
    }

    public void forward() {
        Intent goToSubmitActivity = new Intent(this, alarmeringen_activity.class);
        startActivity(goToSubmitActivity);
    }

    public void RegisterUser() {
        CheckBox memberBox = (CheckBox) findViewById(R.id.checkBox);
        EditText userName = (EditText) findViewById(R.id.username);
        EditText password = (EditText) findViewById(R.id.password);
        EditText repeatPass = (EditText) findViewById(R.id.repeatPass);

        String name = userName.getText().toString();
        String pass = password.getText().toString();
        String passCompare = repeatPass.getText().toString();

        if (name.length() != 0){
            if (pass.length() != 0){
                if (pass.equals(passCompare)){
                    if (memberBox.isChecked()){
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putBoolean("login", true);
                        editor.putString("username", name);
                        editor.putString("password", pass);
                        editor.apply();
                    }
                    // TODO: zet alles in database.
                    Toast toast = Toast.makeText(this, "Bedankt voor het registreren", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    Toast toast = Toast.makeText(this, "Wachtwoorden komen niet overeen", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
            else{
                Toast toast = Toast.makeText(this, "Vul een wachtwoord in", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
        else{
            Toast toast = Toast.makeText(this, "Vul een naam in", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
