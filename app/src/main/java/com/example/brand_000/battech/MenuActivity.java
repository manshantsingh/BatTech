package com.example.brand_000.battech;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void camera(View view) {
        goToCamera(view);
    }

    public void file(View view) {
        goToFile(view);
    }

    public void gps(View view) {
        goToGps(view);
    }

    public void morse(View view) {
        goToMorse(view);
    }

    public void goToCamera(View view) {
        Intent intent = new Intent(this, CameraActivity.class);
        startActivity(intent);
    }

    public void goToFile(View view) {
        Intent intent = new Intent(this, FileActivity.class);
        startActivity(intent);
    }

    public void goToGps(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    public void goToMorse(View view) {
        Intent intent = new Intent(this, MorseActivity.class);
        startActivity(intent);
    }
}
