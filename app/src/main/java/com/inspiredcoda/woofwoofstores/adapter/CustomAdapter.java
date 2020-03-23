package com.inspiredcoda.woofwoofstores.adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.inspiredcoda.woofwoofstores.BuyDog;
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

    class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CardView mainCard;
        ImageView dogImage;
        TextView location;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            mainCard = itemView.findViewById(R.id.main_card);
            dogImage = itemView.findViewById(R.id.dog_image);
            location = itemView.findViewById(R.id.location);

            dogImage.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
//                case R.id.main_card:
//
//                    Toast.makeText(itemView.getContext(), "Main card touched", Toast.LENGTH_SHORT).show();
//                    break;
                case R.id.dog_image:
                    Intent intent = new Intent(itemView.getContext(), BuyDog.class);
                    intent.putExtra("dog_name", dogs.get(getAdapterPosition()).getName());
                    intent.putExtra("dog_image", dogs.get(getAdapterPosition()).getDogImage());
                    intent.putExtra("dog_sex", dogs.get(getAdapterPosition()).getSex());
                    intent.putExtra("dog_age", dogs.get(getAdapterPosition()).getAgeInMonths());
                    intent.putExtra("dog_location", dogs.get(getAdapterPosition()).getLocation());
                    intent.putExtra("dog_background", dogs.get(getAdapterPosition()).getBackground());
                    intent.putExtra("dog_price", dogs.get(getAdapterPosition()).getPrice());
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                        ActivityOptions options = ActivityOptions
                                .makeSceneTransitionAnimation((Activity) itemView.getContext(),
                                        dogImage,
                                        "common_dog");
                        itemView.getContext().startActivity(intent, options.toBundle());
                    }else{
                        itemView.getContext().startActivity(intent);
                    }
                    Toast.makeText(itemView.getContext(), "Dog touched", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
