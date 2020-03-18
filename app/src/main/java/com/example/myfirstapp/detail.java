package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

import java.util.ArrayList;

public class detail extends AppCompatActivity {

    private String TAG;
    private TextView mTitle;
    private TextView mSymbol;
    private TextView mName;
    private TextView mValue;
    private TextView mChange;
    private TextView mChange24;
    private TextView mChange7d;
    private TextView mMarket;
    private TextView mVolume;
    private ImageView mSearch;
    private Coin mCoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

         Intent intent = getIntent();
        int position = intent.getIntExtra(MainActivity.EXTRA_MESSAGE, 0);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = new myFragment();
        Bundle arguments = new Bundle();
        arguments.putInt("position", position);
        fragment.setArguments(arguments);
        transaction.replace(R.id.scrollView2, fragment);
        transaction.commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.scrollView2, fragment).commit();









}}