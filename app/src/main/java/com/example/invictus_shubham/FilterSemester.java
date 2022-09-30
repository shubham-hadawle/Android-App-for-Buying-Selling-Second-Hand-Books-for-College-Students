package com.example.invictus_shubham;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class FilterSemester extends AppCompatActivity implements View.OnClickListener{

    String sem; //Variable to send Semester attribute to Firebase.
    public CardView card1, card2, card3, card4, card5, card6, card7, card8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_semester);

        card1 = findViewById(R.id.c1);
        card2 = findViewById(R.id.c2);
        card3 = findViewById(R.id.c3);
        card4 = findViewById(R.id.c4);
        card5 = findViewById(R.id.c5);
        card6 = findViewById(R.id.c6);
        card7 = findViewById(R.id.c7);
        card8 = findViewById(R.id.c8);
        
        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);
        card6.setOnClickListener(this);
        card7.setOnClickListener(this);
        card8.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch(view.getId())
        {
            case R.id.c1 :
                sem = "Sem1";
                i = new Intent(this, Sem1.class);
                startActivity(i);
                break;

            case R.id.c2 :
                sem = "Sem2";
                i = new Intent(this, Sem2.class);
                startActivity(i);
                break;

            default :
                Toast.makeText(this, "This will open the page for the respective Semester.", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}