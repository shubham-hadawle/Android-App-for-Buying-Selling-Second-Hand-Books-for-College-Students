package com.example.invictus_shubham;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class ListingActivity extends AppCompatActivity {

    //Providing the Data
    String[] books = {"BEE", "Mechanics", "Maths - 1", "Chemistry", "Physics", "C Programming"};
    String[] authors = {"B. R. Patil", "M. D. Dayal", "Kumbhojkar", "Nirali Publications", "Techneo", "Let us C"};
    int[] images = {android.R.drawable.ic_menu_camera, android.R.drawable.ic_menu_camera, android.R.drawable.ic_menu_camera, android.R.drawable.ic_menu_camera, android.R.drawable.ic_menu_camera, android.R.drawable.ic_menu_camera};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);

        //Initializing the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        //Assigning a Layout Manager to the Recycler View
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Combining the Adapter with the Recycler View
        AdapterClassForListing adapter = new AdapterClassForListing(books, authors, images);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(recyclerView.getLayoutManager());
        adapter.OnRecyclerViewClickListener(new AdapterClassForListing.OnRecyclerViewClickListener() {
            @Override
            public void onItemClick(int position){
                Intent i = new Intent(ListingActivity.this, ProfilePage.class);
                startActivity(i);
            }
        });
    }
}