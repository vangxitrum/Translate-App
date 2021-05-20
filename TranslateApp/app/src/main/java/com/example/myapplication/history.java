package com.example.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class history extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageButton sideMenuButton;
    boolean mSlideState;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        drawerLayout = findViewById(R.id.drawer_Layout);
        navigationView = findViewById(R.id.nav_view);
        sideMenuButton = findViewById(R.id.sideMenuButton);
        listView = findViewById(R.id.history);
        mSlideState = false;
        drawerLayout.setDrawerListener(new ActionBarDrawerToggle(this,drawerLayout,null,0,0){

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                mSlideState=false;//is Closed
            }
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                mSlideState=true;//is Opened
            }});
            sideMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mSlideState){
                    drawerLayout.closeDrawer(Gravity.START);
                }else{
                    drawerLayout.openDrawer(Gravity.START);
                }
            }
        });
            HashMap<String,String> data = new HashMap<>();
            data.put("Yasuo","số 1 thế giới");
            data.put("Yone","số 1 thế giới");
        List<HashMap<String,String>> itemList = new ArrayList<>();
        loadListviewData(itemList,data);
        SimpleAdapter adapter = new SimpleAdapter(this,itemList,R.layout.list_item,new String[] {"First Line","Second Line"},new int[]{
                R.id.word,R.id.defination});
        listView.setAdapter(adapter);

        Intent intent = new Intent(this, MainActivity.class);
        Intent intent1 = new Intent(this, history.class);
        Intent intent2 = new Intent(this, FirstGame.class);
        Intent intent3 = new Intent(this, SecondGame.class);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Log.d("chum","test");
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                // Stuff that updates the UI
                                setContentView(R.layout.activity_main);
                                startActivity(intent);
                            }
                        });
                        return true;
                    case R.id.history:

                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                // Stuff that updates the UI
                                setContentView(R.layout.activity_history);
                                startActivity(intent1);
                            }
                        });
                        return true;
                    case R.id.rememberGame:

                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                // Stuff that updates the UI
                                setContentView(R.layout.activity_first_game);
                                startActivity(intent2);
                            }
                        });
                        return true;
                    case R.id.cardGame:

                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                // Stuff that updates the UI
                                setContentView(R.layout.activity_second_game);
                                startActivity(intent3);
                            }
                        });
                        return true;
                    case R.id.setting:
                        return true;
                    default:
                        return true;
                }
            }
        });

    }

    private void loadListviewData(List<HashMap<String,String>> itemList ,HashMap<String,String> data){
        Iterator it = data.entrySet().iterator();
        while (it.hasNext()){
            HashMap<String,String> rsMap = new HashMap<>();
            Map.Entry pair = (Map.Entry)it.next();
            rsMap.put("First Line",pair.getKey().toString());
            rsMap.put("Second Line", pair.getValue().toString());
            itemList.add(rsMap);
        }
    }
}