package com.example.dictionary_ui;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ArrayAdapter<String> arrayAdapter;
    CardView setting;
    CardView rememberGame;
    CardView cardGame;
    CardView history;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setting = findViewById(R.id.settingBt);
        rememberGame = findViewById(R.id.rememberGameBt);
        cardGame = findViewById(R.id.cardGameBt);
        history = findViewById(R.id.historyBt);
        Intent historyIt = new Intent(this, history.class);
        Intent settingIt = new Intent(this, setting.class);
        Intent rememberIt = new Intent(this, rememberGame.class);
        Intent cardGameIt = new Intent(this, cardGame.class);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_setting);
                startActivity(settingIt);
            }
        });
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_history);
                startActivity(historyIt);
            }
        });
        rememberGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_remember_game);
                startActivity(rememberIt);
            }
        });
        cardGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_card_game);
                startActivity(cardGameIt);
            }
        });


        searchView = findViewById(R.id.search_view_id);
        ListView listView = findViewById(R.id.rs_list);
        List<String> myList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,myList);
        listView.setAdapter(arrayAdapter);
        myList.add("test");
        myList.add("yasuo");
        myList.add("zed");
        listView.setAdapter(arrayAdapter);
        searchView.setQueryHint("Search Here");

        searchView.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener() {
            ConstraintLayout temp = findViewById(R.id.main_bg);
            @Override
            public boolean onQueryTextSubmit(String query) {
                listView.setVisibility(View.GONE);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                listView.setVisibility(View.VISIBLE);
                arrayAdapter.getFilter().filter(newText);
                return true;
            }
        });


        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            ConstraintLayout temp = findViewById(R.id.main_bg);
            @Override
            public boolean onClose() {
                listView.setVisibility(View.GONE);
                return false;
            }
        });

        /*searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!searchView.hasFocus()){
                    searchView.setIconifiedByDefault(true);
                    searchView.onActionViewExpanded();

                }

            }
        });*/


    }
}
