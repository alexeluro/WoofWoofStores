package com.inspiredcoda.woofwoofstores.ui.cart;

import com.inspiredcoda.woofwoofstores.CartManager;
import com.inspiredcoda.woofwoofstores.model.CartItem;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CartViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<List<CartItem>> mutableCartItems = new MutableLiveData<>();

    public void init(){
        CartManager manager = new CartManager();
        mutableCartItems.setValue(manager.getItemsFromCart());
    }

    public LiveData<List<CartItem>> getCartItems(){
        return mutableCartItems;
    }



}
