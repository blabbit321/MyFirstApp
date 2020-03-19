package com.example.myfirstapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.DecimalFormat;

public class myFragment extends Fragment {

    private TextView mCoinName;
    private TextView mCoinSymbol;
    private TextView mValue;
    private TextView mChange;
    private TextView mChange24h;
    private TextView mChange7d;
    private TextView mMarket;
    private TextView mVolume;
    private ImageView mSearch;

    public myFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_my, container, false);
        Bundle bundle = getArguments();
        int position = bundle.getInt("POSITION");
        Coin coin = Coin.getCoins().get(position);
        mCoinName = v.findViewById(R.id.coinName);
        mCoinSymbol = v.findViewById(R.id.coinSymbol);
        mValue = v.findViewById(R.id.value);
        mChange = v.findViewById(R.id.change);
        mChange24h = v.findViewById(R.id.change24);
        mChange7d = v.findViewById(R.id.change7d);
        mMarket = v.findViewById(R.id.market);
        mVolume = v.findViewById(R.id.volume);
        mSearch = v.findViewById(R.id.search);

        mCoinName.setText(coin.getName());
        mCoinSymbol.setText(coin.getSymbol());
        mValue.setText("$" + coin.getValue());
        mChange.setText(coin.getChange1h() + " %");
        mChange24h.setText(coin.getChange24h() + " %");
        mChange7d.setText(coin.getChange7d() + " %");
        DecimalFormat formatter = new DecimalFormat("#,###,###.##");
        String vol = formatter.format(coin.getVolume());
        String mark = formatter.format(coin.getMarketcap());
        mMarket.setText("$" + mark);
        mVolume.setText("$" + vol);

        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search();
            }
        });
        return v;
    }
    private void search() {
        String url = "https://coinmarketcap.com/all/views/all/";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

}