package com.inspiredcoda.woofwoofstores.ui.buydogfood;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.inspiredcoda.woofwoofstores.R;
import com.inspiredcoda.woofwoofstores.adapter.FoodAdapter;
import com.inspiredcoda.woofwoofstores.model.DogFood;

import java.util.List;

public class BuyDogFoodFragment extends Fragment {

    private BuyDogFoodViewModel buyDogFoodViewModel;
    private RecyclerView buyFoodRecyclerView;
    private FoodAdapter adapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_buy_dog_food, container, false);

        buyFoodRecyclerView = root.findViewById(R.id.buy_food_recyclerview);

        buyDogFoodViewModel = ViewModelProviders.of(this).get(BuyDogFoodViewModel.class);
        buyDogFoodViewModel.getDogFood().observe(getViewLifecycleOwner(), new Observer<List<DogFood>>() {
            @Override
            public void onChanged(List<DogFood> dogFoods) {
                if (adapter == null){
                    adapter = new FoodAdapter(dogFoods);
                    initRecyclerView();
                }else{
                    adapter.notifyDataSetChanged();
                }
            }
        });
        return root;
    }

    private void initRecyclerView(){
        buyFoodRecyclerView.setAdapter(adapter);
        if(getContext().getResources().getConfiguration().orientation == GridLayoutManager.VERTICAL){
            buyFoodRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        }else{
            buyFoodRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));
        }
    }
}