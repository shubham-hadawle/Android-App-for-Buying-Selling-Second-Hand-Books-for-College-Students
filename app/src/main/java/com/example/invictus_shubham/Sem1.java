package com.example.invictus_shubham;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Sem1 extends AppCompatActivity {

    String subject; //This is a variable to accept input to which subject is chosen.
    String subj1, subj2, subj3, subj4, subj5, subj6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sem1);

        ListView listView = findViewById(R.id.lv1);

        //Hardcoding for now, can change while fetching from Database
        subj1 = "Maths - 1";
        subj2 = "BEE";
        subj3 = "Mechanics";
        subj4 = "Physics";
        subj5 = "Chemistry";

        List<String> list = new ArrayList<>();
        list.add(subj1);
        list.add(subj2);
        list.add(subj3);
        list.add(subj4);
        list.add(subj5);

        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0)
                {
                    //Subject 1 is clicked
                    subject = subj1;
                }
                else if(i == 1)
                {
                    //Subject 2 is clicked
                    subject = subj2;
                }
                else if(i == 2)
                {
                    //Subject 3 is clicked
                    subject = subj3;
                }
                else if(i == 3)
                {
                    //Subject 4 is clicked
                    subject = subj4;
                }
                else if(i == 4)
                {
                    //Subject 5 is clicked
                    subject = subj5;
                }
                Intent intentObj = new Intent(Sem1.this, ChooseBuyerOrSeller.class);
                startActivity(intentObj);
            }
        });
    }
}