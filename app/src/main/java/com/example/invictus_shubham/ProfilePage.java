package com.example.invictus_shubham;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfilePage extends AppCompatActivity {

    ImageView bookImage;
    TextView bookName, authorOrPublication, sellerName, sellerContact, cost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        bookImage = findViewById(R.id.BookImage);
        bookName = findViewById(R.id.BookName);
        authorOrPublication = findViewById(R.id.AuthorOrPublication);
        sellerName = findViewById(R.id.SellerName);
        sellerContact = findViewById(R.id.SellerContact);
        cost = findViewById(R.id.SellerContact);
    }
}