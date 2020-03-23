package com.inspiredcoda.woofwoofstores;

import com.inspiredcoda.woofwoofstores.model.CartItem;

import java.util.ArrayList;
import java.util.List;

public class CartManager {

    private static List<CartItem> items = new ArrayList<>();
    private static CartManager instance;

    public static CartManager getInstance(){
        if(instance == null){
            instance = new CartManager();
        }
        return instance;
    }

    public void addItemToCart(CartItem cartItem){
        items.add(cartItem);
    }

    public List<CartItem> getItemsFromCart(){
        return items;
    }

}
