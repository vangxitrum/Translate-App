package com.example.dictionary_ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ArrayAdapter<String> arrayAdapter;
    CardView setting;
    CardView rememberGame;
    CardView cardGame;
    CardView history;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.result_list);
        List<String> myList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,myList);
        listView.setAdapter(arrayAdapter);
        setting = findViewById(R.id.settingBt);
        rememberGame = findViewById(R.id.rememberGameBt);
        cardGame = findViewById(R.id.cardGameBt);
        history = findViewById(R.id.historyBt);
        Intent historyIt = new Intent(this,history.class);
        Intent settingIt = new Intent(this,setting.class);
        Intent rememberIt = new Intent(this,rememberGame.class);
        Intent cardGameIt = new Intent(this,cardGame.class);
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



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.nav_menu,menu);
        MenuItem menuItem = menu.findItem(R.id.nav_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Search Here");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                arrayAdapter.getFilter().filter(newText);
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }}
