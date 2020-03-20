package com.inspiredcoda.woofwoofstores.ui.buydogfood;

import com.inspiredcoda.woofwoofstores.R;
import com.inspiredcoda.woofwoofstores.model.DogFood;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BuyDogFoodViewModel extends ViewModel {

    private MutableLiveData<List<DogFood>> foods;

    public BuyDogFoodViewModel() {
        foods = new MutableLiveData<>();
        foods.setValue(addFoods());
    }

    private List<DogFood> addFoods(){
        List<DogFood> foodList = new ArrayList<>();
        foodList.add(new DogFood( "Scooby Snacks",10, R.drawable.dog_food_1));
        foodList.add(new DogFood("Snacks",7, R.drawable.dog_food_2));
        foodList.add(new DogFood("Dog Treats",15, R.drawable.dog_food_3));
        foodList.add(new DogFood("Cereal",70, R.drawable.dog_food_1));
        foodList.add(new DogFood("Med Snacks",25, R.drawable.dog_food_2));
        foodList.add(new DogFood("Chips",40, R.drawable.dog_food_3));
        return foodList;
    }

    public LiveData<List<DogFood>> getDogFood() {
        return foods;
    }
}