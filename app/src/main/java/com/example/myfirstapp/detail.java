package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

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
        ArrayList<Coin> coins = Coin.getCoins();
        mCoin=coins.get(position);


       // final  String cSymbol = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);




         Coin coin = Coin.searchCoin(mCoin.getSymbol());
         Log.i(TAG, "Coin-Symbol = " + coin.getSymbol());



         mSearch = (ImageView) findViewById(R.id.tvSearch);

        mSymbol = (TextView) findViewById(R.id.coinSymbol);
        mName = (TextView) findViewById(R.id.title);
        mSymbol.setText(coin.getSymbol());
        mValue = (TextView) findViewById(R.id.tvValueField);

        mValue.setText("$"+ coin.getValue());
        mChange = (TextView) findViewById(R.id.tvChangeField);
        mChange.setText(coin.getChange1h()+"%");

        mChange24 = (TextView) findViewById(R.id.tvChange24);
        mChange24.setText(coin.getChange24h()+"%");

        mChange7d = (TextView) findViewById(R.id.tv7d);
        mChange7d.setText(coin.getChange7d()+"%");

        mTitle = (TextView) findViewById(R.id.title);
        mTitle.setText(coin.getName());




        DecimalFormat formatter = new DecimalFormat("#,###,###.##");
        String volume = formatter.format(coin.getVolume());
        String market = formatter.format(coin.getMarketcap());

        mMarket = (TextView) findViewById(R.id.tvMarket);
        mMarket.setText("$"+market);

        mVolume = (TextView) findViewById(R.id.tvVolume);
        mVolume.setText("$"+volume);




        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search(mCoin.getSymbol());
            }
        });




        }
        private void search(String google){
        String query = "https://www.google.com/search?q=" + google;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(query));
        startActivity(intent);


    }



}