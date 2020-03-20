package com.inspiredcoda.woofwoofstores.adapter;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.content.Intent;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.inspiredcoda.woofwoofstores.PayForDogFood;
import com.inspiredcoda.woofwoofstores.R;
import com.inspiredcoda.woofwoofstores.model.DogFood;
import com.inspiredcoda.woofwoofstores.ui.buydogfood.BuyDogFoodFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private List<DogFood> foods = new ArrayList<>();

    public FoodAdapter(List<DogFood> foods) {
        this.foods = foods;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewer = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dog_food_layout, parent, false);
        return new FoodViewHolder(viewer);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        holder.foodName.setText(foods.get(position).getFoodName());
        holder.foodImage.setImageResource(foods.get(position).getFoodImage());
        holder.foodPrice.setText(foods.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    class FoodViewHolder extends RecyclerView.ViewHolder{

        private static final String COMMON_IMAGE = "commonImage";

        ImageView foodImage;
        TextView foodPrice, foodName;

        public FoodViewHolder(@NonNull final View itemView) {
            super(itemView);

            foodImage = itemView.findViewById(R.id.buy_food_image);
            foodPrice = itemView.findViewById(R.id.buy_food_price);
            foodName = itemView.findViewById(R.id.buy_food_name);

            foodImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(itemView.getContext(), PayForDogFood.class);
                    intent.putExtra("food_name", foods.get(getAdapterPosition()).getFoodName());
                    intent.putExtra("food_price", foods.get(getAdapterPosition()).getPrice());
                    intent.putExtra("food_image", foods.get(getAdapterPosition()).getFoodImage());
                    itemView.getContext().startActivity(intent);

//                    Pair[] pairs = new Pair[1];
//                    pairs[0] = new Pair<View, String>(foodImage, COMMON_IMAGE);
//                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
//                        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(itemView.getContext(), pairs);
//                        itemView.getContext().startActivity(intent, options.toBundle());
//                    }else{
//                        itemView.getContext().startActivity(intent);
//                    }
                }
            });
        }
    }
}
