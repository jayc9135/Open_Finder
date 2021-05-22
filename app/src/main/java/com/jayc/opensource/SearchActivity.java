package com.jayc.opensource;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class SearchActivity extends AppCompatActivity {

    private Button backBtn;
    private SearchView searchBar;

    private FirebaseFirestore firebaseFirestore;
    private RecyclerView searchRecView;
    private FirestoreRecyclerAdapter adapter;


    public void openActivity2(){
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_search);

        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        firebaseFirestore = FirebaseFirestore.getInstance();
        searchRecView = findViewById(R.id.searchRecView);
        Query query = firebaseFirestore.collection("MainDb");
        FirestoreRecyclerOptions<MainDatabaseModel> options = new FirestoreRecyclerOptions.Builder<MainDatabaseModel>()
                .setQuery(query, MainDatabaseModel.class)
                .build();

        adapter = new FirestoreRecyclerAdapter<MainDatabaseModel, ItemsViewHolder>(options) {
            @NonNull
            @Override
            public ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_item_single, parent, false);
                ItemsViewHolder holder = new ItemsViewHolder(view);
                return holder;
            }

            @Override
            protected void onBindViewHolder(@NonNull ItemsViewHolder holder, int position, @NonNull MainDatabaseModel model) {
                holder.txtPaid.setText(model.getPaid());
                holder.txtAlternative1.setText(model.getAlternative1());
                holder.txtAlternative2.setText(model.getAlternative2());
                holder.txtAlternative3.setText(model.getAlternative3());
            }

        };

        searchRecView.setHasFixedSize(true);
        searchRecView.setLayoutManager(new LinearLayoutManager(this));
        searchRecView.setAdapter(adapter);

        searchBar = findViewById(R.id.searchBar);
        searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String s =  searchBar.getQuery().toString();
                s = s.toLowerCase();
                char[] ch = s.toCharArray();
                Query query1 = firebaseFirestore.collection("MainDb").whereArrayContains("searchtext", s);
                FirestoreRecyclerOptions<MainDatabaseModel> options = new FirestoreRecyclerOptions.Builder<MainDatabaseModel>()
                        .setQuery(query1, MainDatabaseModel.class)
                        .build();

                adapter.updateOptions(options);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                String s =  searchBar.getQuery().toString();
                if(s.toString().isEmpty()){
                    Query query = firebaseFirestore.collection("MainDb");
                    FirestoreRecyclerOptions<MainDatabaseModel> options = new FirestoreRecyclerOptions.Builder<MainDatabaseModel>()
                            .setQuery(query, MainDatabaseModel.class)
                            .build();

                    adapter.updateOptions(options);
                } else {
                    s =s.toLowerCase();
                    Query query = firebaseFirestore.collection("MainDb").whereArrayContains("searchtext", s);
                    FirestoreRecyclerOptions<MainDatabaseModel> options = new FirestoreRecyclerOptions.Builder<MainDatabaseModel>()
                            .setQuery(query, MainDatabaseModel.class)
                            .build();

                    adapter.updateOptions(options);
                }
                return false;
            }
        });
    }

    private class ItemsViewHolder extends RecyclerView.ViewHolder {

        private TextView txtPaid;
        private TextView txtAlternative1;
        private TextView txtAlternative2;
        private TextView txtAlternative3;

        public ItemsViewHolder(@NonNull View itemView) {
            super(itemView);
            txtPaid = itemView.findViewById(R.id.txtPaid);
            txtAlternative1 = itemView.findViewById(R.id.txtAlternative1);
            txtAlternative2 = itemView.findViewById(R.id.txtAlternative2);
            txtAlternative3 = itemView.findViewById(R.id.txtAlternative3);
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
}