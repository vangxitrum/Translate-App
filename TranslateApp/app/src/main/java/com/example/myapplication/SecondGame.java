package com.example.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
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

public class SecondGame extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageButton sideMenuButton;
    boolean mSlideState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_game);

        drawerLayout = findViewById(R.id.drawer_Layout);
        navigationView = findViewById(R.id.nav_view);
        sideMenuButton = findViewById(R.id.sideMenuButton);
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




}