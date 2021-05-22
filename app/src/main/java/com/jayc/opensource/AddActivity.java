 package com.jayc.opensource;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jayc.opensource.model.UserInput;

public class AddActivity extends AppCompatActivity {

    private Button enterBtn;
    private Button backBtn;
    private RelativeLayout parent;
    private EditText paidInput;
    private EditText alternateInput;
    private UserInput userinput = new UserInput();

    FirebaseDatabase rootnode;
    DatabaseReference reference;

    public void openActivity2(){
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    public void showSnackbar(){
        Snackbar.make(parent, "YOUR INPUT IS REGISTERED", BaseTransientBottomBar.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_add);

        paidInput = findViewById(R.id.paidInput);
        alternateInput = findViewById(R.id.alternateInput);

        parent = findViewById(R.id.parent);
        enterBtn = findViewById(R.id.enterBtn);
        enterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootnode = FirebaseDatabase.getInstance();
                reference = rootnode.getReference("UserInput");

                String paid = paidInput.getText().toString();
                String alternative = alternateInput.getText().toString();
                UserInput userInputForFirebase = new UserInput(paid, alternative);
                reference.push().setValue(userInputForFirebase);

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