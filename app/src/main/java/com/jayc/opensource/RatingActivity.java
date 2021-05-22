package com.jayc.opensource;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.RelativeLayout;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jayc.opensource.model.Ratings;

public class RatingActivity extends AppCompatActivity {
    private Button backBtn;
    private Button enterBtn;
    private RelativeLayout parent1;
    private RatingBar stars;
    private EditText enterName;
    private EditText suggestionBox;
    private Ratings rating = new Ratings();

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    public void openActivity2(){
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    public void showSnackbar(){
        Snackbar.make(parent1, "YOUR INPUT IS REGISTERED", BaseTransientBottomBar.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_rating);

        parent1 = findViewById(R.id.parent1);
        enterName = findViewById(R.id.enterName);
        stars = findViewById(R.id.stars);
        suggestionBox = findViewById(R.id.suggestionBox);

        enterBtn = findViewById(R.id.enterBtn);
        enterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Ratings");

                String name = enterName.getText().toString();
                float starsRating = stars.getRating();
                String suggestion = suggestionBox.getText().toString();

                Ratings ratingForFirebase = new Ratings(name, starsRating, suggestion);

                reference.push().setValue(ratingForFirebase);
                showSnackbar();
            }
        });

        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

    }
}