package com.inspiredcoda.woofwoofstores;

import com.inspiredcoda.woofwoofstores.model.CartItem;
import com.inspiredcoda.woofwoofstores.model.Dog;

import java.util.ArrayList;
import java.util.List;

public class DogKeeper {

    private static List<CartItem> dogs = new ArrayList<>();
    private static DogKeeper instance;

    public static DogKeeper getInstance(){
        if(instance == null){
            instance = new DogKeeper();
        }
        return instance;
    }

    public void addDogToKennel(CartItem dog){
        dogs.add(dog);
    }

    public List<CartItem> getDogsFromKeeper(){
        return dogs;
    }





}
