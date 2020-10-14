package com.sujyotraut.daily.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import com.sujyotraut.daily.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "myTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);

        initView();
    }

    private void initView(){
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        MaterialToolbar toolbar = findViewById(R.id.mtb_main);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this,
                drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item_main_analytics:
                        Log.d(TAG, "onNavigationItemSelected: analytics");
                        break;
                    case R.id.item_main_completed:
                        Log.d(TAG, "onNavigationItemSelected: completed");
                        break;
                    case R.id.item_main_settings:
                        Log.d(TAG, "onNavigationItemSelected: settings");
                        break;
                    case R.id.item_main_about:
                        Log.d(TAG, "onNavigationItemSelected: about");
                        break;
                }
                return true;
            }
        });
    }

    public void addNewTask(View view) {
        startActivity(new Intent(MainActivity.this, NewTaskActivity.class));
    }
}