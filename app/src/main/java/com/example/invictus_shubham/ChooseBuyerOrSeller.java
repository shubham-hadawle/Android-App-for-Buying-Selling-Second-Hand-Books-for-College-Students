package com.example.invictus_shubham;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseBuyerOrSeller extends AppCompatActivity {

    Button bBuy, bSell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_buyer_or_seller);

        bBuy = findViewById(R.id.button2);
        bSell = findViewById(R.id.button3);

        bBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChooseBuyerOrSeller.this, ListingActivity.class);
                startActivity(i);
            }
        });

        bSell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChooseBuyerOrSeller.this, SellerPage.class);
                startActivity(i);
            }
        });
    }
}