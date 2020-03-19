package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

public class detail extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        int position = intent.getIntExtra(MainActivity.EXTRA_MESSAGE, 0);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment myFragment = new myFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("POSITION", position);
        myFragment.setArguments(bundle);
        transaction.replace(R.id.scroller, myFragment);
        transaction.commit();

    }

}