package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public static final String EXTRA_MESSAGE = "au.edu.unsw.infs3634.beers.MESSAGE";
    private Button nButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         Log.i(TAG,"OnCreate Called");
        setContentView(R.layout.activity_main);

        nButton = findViewById(R.id.nButton);
        nButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        nButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchDetailActivity("BTC");

            }
        });
    }

    private void launchDetailActivity(String message) {
        Intent intent = new Intent(this, detail.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }



}

