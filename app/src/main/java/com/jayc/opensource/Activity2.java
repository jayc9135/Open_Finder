package com.jayc.opensource;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Activity2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private MaterialCardView card1;
    private RecyclerView contactsView;
    private DrawerLayout drawerLayout;
    private NavigationView navView;
    Toolbar toolbar;
    private SearchView mainSearchView;


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

    public void openPhotoEditingActivity(){
        Intent intent = new Intent(this, PhotoEditing.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        mainSearchView = findViewById(R.id.mainSearchView);
        mainSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String s =  mainSearchView.getQuery().toString();
                Toast.makeText(Activity2.this, s+" will be searched", Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                String s =  mainSearchView.getQuery().toString();
                Toast.makeText(Activity2.this, s+" will be searched", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

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
        cards.add(new Card("PHOTO EDITING", "name1@gmail.com", "https://pngimg.com/uploads/photoshop/photoshop_PNG64.png"));
        cards.add(new Card("BROWSER", "name2@gmail.com", "https://raw.githubusercontent.com/alrra/browser-logos/master/src/main-desktop-browser-logos.png"));
        cards.add(new Card("VIDEO EDITING", "name3@gmail.com", "https://toppng.com/uploads/preview/why-professional-video-editing-video-edit-logo-11562924502ycdlfj9ec6.png"));
        cards.add(new Card("PC OPERATING SYSTEM", "name4@gmail.com", "https://d3fhk62vq6ub16.cloudfront.net/uploads/2018/12/operating-sys.png"));
        cards.add(new Card("MOBILE OPERATING SYSTEM", "name5@gmail.com", "https://www.ccsinsight.com/images/blog/2017/01/IOS_Android_l.png"));
        cards.add(new Card("ANIMATION CREATION", "name6@gmail.com", "https://img.favpng.com/20/8/12/digital-video-animated-film-image-raw-shorts-inc-png-favpng-akPDtGFszPzEg8ArJSJdEpi5n.jpg"));
        cards.add(new Card("3D RENDERING SOFTWARE", "name7@gmail.com", "https://w7.pngwing.com/pngs/394/296/png-transparent-3d-computer-graphics-3d-modeling-animation-animation-purple-3d-computer-graphics-text-thumbnail.png"));
        cards.add(new Card("MEDIA PLAYERS", "name8@gmail.com", "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e6/VLC_Icon.svg/530px-VLC_Icon.svg.png"));
        cards.add(new Card("OFFICE SOFTWARE", "name9@gmail.com", "https://img2.pngio.com/excel-logo-png-download-1600763-free-transparent-microsoft-microsoft-office-2016-png-900_440.jpg"));
        cards.add(new Card("PROGRAMMING LANGUAGE", "name10@gmail.com", "https://www.sandeepkumar.co.in/assets/img/blog/top-5-programming-languages.png"));
        CardsRecViewAdapter adapter = new CardsRecViewAdapter(this);
        adapter.setCards(cards);
        contactsView.setAdapter(adapter);
        contactsView.setLayoutManager(new GridLayoutManager(this, 2));

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
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}