package com.jayc.opensource;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class PhotoEditing extends AppCompatActivity {

    private Button backBtn;

    private FirebaseFirestore firebaseFirestore;
    private RecyclerView descriptionRecView;
    private FirestoreRecyclerAdapter adapter;
    private Context contextfrom = PhotoEditing.this;

    public void openActivity2(){
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_photo_editing);

        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        firebaseFirestore = FirebaseFirestore.getInstance();
        descriptionRecView = findViewById(R.id.descriptionRecView);
        Query query = getIncomingIntent();
        FirestoreRecyclerOptions<DescriptionModel> options = new FirestoreRecyclerOptions.Builder<DescriptionModel>()
                .setQuery(query, DescriptionModel.class)
                .build();

        adapter = new FirestoreRecyclerAdapter<DescriptionModel, ItemsViewHolder>(options) {
            @NonNull
            @Override
            public ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.description_item_single, parent, false);
                ItemsViewHolder holder = new ItemsViewHolder(view);
                return holder;
            }

            @Override
            protected void onBindViewHolder(@NonNull ItemsViewHolder holder, int position, @NonNull DescriptionModel model) {
                holder.heading.setText(model.getHeading());
                holder.description.setText(model.getDescription());
                holder.sourcecode.setText(model.getSourcecode());
                holder.downloadlink.setText(model.getDownloadlink());

                Glide.with(contextfrom)
                        .asBitmap()
                        .load(model.getDescriptionImage())
                        .into(holder.descriptionImage);
            }
        };

        descriptionRecView.setHasFixedSize(true);
        descriptionRecView.setLayoutManager(new LinearLayoutManager(this));
        descriptionRecView.setAdapter(adapter);
    }

    private class ItemsViewHolder extends RecyclerView.ViewHolder {

        private TextView heading;
        private TextView description;
        private TextView sourcecode;
        private ImageView descriptionImage;
        private TextView downloadlink;

        public ItemsViewHolder(@NonNull View itemView) {
            super(itemView);
            heading = itemView.findViewById(R.id.heading);
            description = itemView.findViewById(R.id.description);
            sourcecode = itemView.findViewById(R.id.sourcecode);
            descriptionImage = itemView.findViewById(R.id.descritptionImage);
            downloadlink = itemView.findViewById(R.id.downloadlink);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    private Query getIncomingIntent(){
        if(getIntent().hasExtra("category")){
            String category = getIntent().getStringExtra("category");
            setCategory(category);
            category = category.toLowerCase();
            char[] ch = category.toCharArray();
            ch[0] = Character.toUpperCase(ch[0]);
            category = new String(ch);
            Query query = firebaseFirestore.collection(category);
            return query;
        } else {
            Query query = firebaseFirestore.collection("Photoediting");
            return query;
        }
    }

    private void setCategory(String category){
        TextView Category = findViewById(R.id.category);
        category =(String) "|| " + category + " ||";
        Category.setText(category);
    }
}