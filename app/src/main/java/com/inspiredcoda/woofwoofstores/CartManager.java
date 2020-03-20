package com.inspiredcoda.woofwoofstores;

import com.inspiredcoda.woofwoofstores.model.CartItem;

import java.util.ArrayList;
import java.util.List;

public class CartManager {

    private static List<CartItem> items = new ArrayList<>();


    public void addItemToCart(CartItem cartItem){
        items.add(cartItem);
    }

    public List<CartItem> getItemsFromCart(){
        return items;
    }

}
