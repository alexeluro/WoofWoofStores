package com.inspiredcoda.woofwoofstores.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.inspiredcoda.woofwoofstores.model.Dog;
import com.inspiredcoda.woofwoofstores.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<Dog> dogs = new ArrayList<>();

    public CustomAdapter(List<Dog> dogs) {
        this.dogs = dogs;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewer = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_layout, parent, false);
        return new CustomViewHolder(viewer);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.mainCard.setAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.slide_in_anim));
        holder.dogImage.setImageResource(dogs.get(position).getDogImage());
        holder.location.setText(dogs.get(position).getLocation());
    }

    @Override
    public int getItemCount() {
        return dogs.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{

        CardView mainCard;
        ImageView dogImage;
        TextView location;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            mainCard = itemView.findViewById(R.id.main_card);
            dogImage = itemView.findViewById(R.id.dog_image);
            location = itemView.findViewById(R.id.location);

        }
    }
}
