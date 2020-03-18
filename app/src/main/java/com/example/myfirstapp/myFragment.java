package com.example.myfirstapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class myFragment extends Fragment {

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

    public myFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_my, container, false);
        Bundle arguments = getArguments();
        int position = arguments.getInt("POSITION");
        Coin coin = Coin.getCoins().get(position);

        DecimalFormat formatter = new DecimalFormat("#,###,###.##");
        String volume = formatter.format(coin.getVolume());
        String market = formatter.format(coin.getMarketcap());

        mSearch = v.findViewById(R.id.tvSearch);
        mSymbol = v.findViewById(R.id.coinSymbol);
        mName = v.findViewById(R.id.title);
        mValue = v.findViewById(R.id.tvValueField);
        mChange = v.findViewById(R.id.tvChangeField);
        mChange24 = v.findViewById(R.id.tvChange24);
        mChange7d = v.findViewById(R.id.tv7d);
        mMarket = v.findViewById(R.id.tvMarket);
        mVolume = v.findViewById(R.id.tvVolume);


        mSymbol.setText(coin.getSymbol());
        mName.setText(coin.getName());
        mValue.setText("$"+ coin.getValue());
        mChange.setText(coin.getChange1h()+" %");
        mChange24.setText(coin.getChange24h()+" %");
        mChange7d.setText(coin.getChange7d()+" %");
        mMarket.setText("$"+market);
        mVolume.setText("$"+volume);



        boolean wide = false;
        if (this.getArguments() != null){
            wide = getArguments().getBoolean( "wide", true);
        }

        if (wide) {
            mCoin = Coin.getCoins().get(getArguments().getInt("position"));
        } else {
           Intent intent = getActivity().getIntent();
           position = intent.getIntExtra("position",0);
           mCoin = Coin.getCoins().get(position);
        }

        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        mSearch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                search();
            }
        });

        return v;
    }


    private void search() {
        String url = "https://www.google.com/search?q="+mSymbol;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

}






        // Inflate the layout for this fragment






