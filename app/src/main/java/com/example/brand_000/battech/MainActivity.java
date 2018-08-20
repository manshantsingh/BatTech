package com.example.brand_000.battech;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText usernameEditText, passwordEditText;
    public static final String DEFAULT = "not available";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameEditText = (EditText)findViewById(R.id.usernameEditText);
        passwordEditText = (EditText)findViewById(R.id.passwordEditText);
    }

    public void login(View view) {
        SharedPreferences sharedPrefs = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String username = sharedPrefs.getString("username", DEFAULT);
        String password = sharedPrefs.getString("password", DEFAULT);

        if(username.equals(DEFAULT)||password.equals(DEFAULT)) {
            SharedPreferences.Editor editor = sharedPrefs.edit();
            editor.putString("username", usernameEditText.getText().toString());
            editor.putString("password", passwordEditText.getText().toString());
            Toast.makeText(this, "Username and Password saved to Preferences", Toast.LENGTH_LONG).show();
            editor.commit();
            goToMenu(view);
        } else {
            if(username.equals(usernameEditText.getText().toString())&&
                    password.equals(passwordEditText.getText().toString())) {
                Toast.makeText(this, "Welcome Back", Toast.LENGTH_LONG).show();
                goToMenu(view);
            } else {
                Toast.makeText(this, "Username or Password is incorrect", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void createLogin(View view) {
        SharedPreferences sharedPrefs = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("username", usernameEditText.getText().toString());
        editor.putString("password", passwordEditText.getText().toString());
        Toast.makeText(this, "Username and Password saved to Preferences", Toast.LENGTH_LONG).show();
        editor.commit();
        goToMenu(view);
    }

    public void goToMenu(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}
