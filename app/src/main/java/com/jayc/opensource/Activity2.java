package com.jayc.opensource;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Activity2 extends AppCompatActivity {

    private Button searchBtn;
    private FloatingActionButton addBtn;
    private EditText searchBar;
    private String toSearch;
    private MaterialCardView card1;
    private RecyclerView contactsView;

    public void openAddActivity(){
        Intent intent = new Intent(this, AddActivity.class);
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

        searchBar = findViewById(R.id.searchBar);
        searchBtn = findViewById(R.id.searchBtn);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toSearch = searchBar.getText().toString();
                Toast.makeText(Activity2.this, toSearch + " will be searched", Toast.LENGTH_SHORT).show();
            }
        });

        addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddActivity();
            }
        });


//        card1 = findViewById(R.id.card1);
//        card1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openPhotoEditingActivity();
//            }
//        });

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



}