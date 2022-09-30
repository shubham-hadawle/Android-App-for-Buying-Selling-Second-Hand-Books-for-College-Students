package com.example.invictus_shubham;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilterBranch extends AppCompatActivity {

    List<String> groupList;
    List<String> childList;
    Map<String, List<String>> branchCollection;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_branch);
        createGroupList();
        createCollection();
        expandableListView = findViewById(R.id.elvBranches);
        expandableListAdapter = new MyExpandableListAdapter(this, groupList, branchCollection);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
//                Toast.makeText(getApplicationContext(),
//                        expandableListTitle.get(groupPosition) + " List Expanded.",
//                        Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
//                Toast.makeText(getApplicationContext(),
//                        expandableListTitle.get(groupPosition) + " List Collapsed.",
//                        Toast.LENGTH_SHORT).show();

            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                String selectedBranch = expandableListAdapter.getChild(i, i1).toString();
                Toast.makeText(getApplicationContext(), selectedBranch, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(FilterBranch.this, FilterSemester.class);
                startActivity(intent);
                return true;
            }
        });
    }

    private void createCollection() {
        String[] branchModels = {"Computer Science", "IT", "AI & Data Science", "Electronics and Telecommunication", "Electrical", "Mechanical", "Intrumentation"};
        branchCollection = new HashMap<String, List<String>>();
        for(String group: groupList){
            if(group.equals("Select Branch: ")){
                loadChild(branchModels);
            }
            branchCollection.put(group, childList);
        }
    }

    private void loadChild(String[] branchModels) {
        childList = new ArrayList<>();
        for(String model : branchModels){
            childList.add(model);
        }
    }

    private void createGroupList() {
        groupList = new ArrayList<>();
        groupList.add("Select Branch: ");
    }
}