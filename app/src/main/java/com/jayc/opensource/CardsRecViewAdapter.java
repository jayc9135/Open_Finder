package com.jayc.opensource;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class CardsRecViewAdapter extends RecyclerView.Adapter<CardsRecViewAdapter.ViewHolder> {

    private ArrayList<Card> cards = new ArrayList<>();
    private Context contextfrom;

    public CardsRecViewAdapter(Context contextfrom) {
        this.contextfrom = contextfrom;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.txtCard1.setText(cards.get(position).getName());
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contextfrom, PhotoEditing.class);
                intent.putExtra("category", cards.get(position).getName());
                contextfrom.startActivity(intent);
            }
        });
        Glide.with(contextfrom)
                .asBitmap()
                .load(cards.get(position).getImage())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtCard1;
        private CardView parent;
        private ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCard1 = itemView.findViewById(R.id.txtCard1);
            parent = itemView.findViewById(R.id.parent);
            image = itemView.findViewById(R.id.image);
        }
    }
}