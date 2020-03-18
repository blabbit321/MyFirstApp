package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "CryptoBag";
    public static final String EXTRA_MESSAGE = "au.edu.unsw.infs3634.beers.MESSAGE";
    private Button nButton;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.rvList);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        CoinAdapter.RecyclerViewClickListener listener = new CoinAdapter.RecyclerViewClickListener(){
            @Override
                    public void onClick(View view, int position){
                launchDetailActivity(position);
            }
        };
        mAdapter=new CoinAdapter(Coin.getCoins(), listener);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void launchDetailActivity(int position) {
        Intent intent = new Intent(this, detail.class);
        intent.putExtra(EXTRA_MESSAGE, position);
        startActivity(intent);
    }



}

