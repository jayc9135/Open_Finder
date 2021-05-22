package com.jayc.opensource;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;

import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;

import android.view.WindowManager;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.navigation.NavigationView;


import java.util.ArrayList;

public class Activity2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView contactsView;
    private DrawerLayout drawerLayout;
    private NavigationView navView;
    Toolbar toolbar;

    public void openAddActivity(){
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    public void openCreditsActivity(){
        Intent intent = new Intent(this, Credits.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    public void openRatingActivity(){
        Intent intent = new Intent(this, RatingActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    public void openSearchActivity(){
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_2);

        drawerLayout = findViewById(R.id.drawerLayout);
        navView = findViewById(R.id.navView);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navView.setNavigationItemSelectedListener(this);

        contactsView = findViewById(R.id.contactsView);
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card("PHOTOEDITING", R.drawable.photoshop));
        cards.add(new Card("BROWSER", R.drawable.browser));
        cards.add(new Card("VIDEOEDITING", R.drawable.video_editing));
        cards.add(new Card("PC OPERATING SYSTEM", R.drawable.os));
        cards.add(new Card("MOBILE OPERATING SYSTEM", R.drawable.android));
        cards.add(new Card("ANIMATION CREATION", R.drawable.animation));
        cards.add(new Card("3D RENDERING SOFTWARE", R.drawable.fromanimation));
        cards.add(new Card("MEDIA PLAYERS", R.drawable.media));
        cards.add(new Card("OFFICE SOFTWARE", R.drawable.office));
        cards.add(new Card("PROGRAMMING LANGUAGE", R.drawable.languages));
        CardsRecViewAdapter adapter = new CardsRecViewAdapter(this);
        adapter.setCards(cards);
        contactsView.setAdapter(adapter);
        contactsView.setLayoutManager(new GridLayoutManager(this, 1));
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.addData:
                openAddActivity();
                break;
            case R.id.credits:
                openCreditsActivity();
                break;
            case R.id.rateus:
                openRatingActivity();
                break;
            case R.id.search:
                openSearchActivity();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}