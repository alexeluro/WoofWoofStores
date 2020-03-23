package com.inspiredcoda.woofwoofstores.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.inspiredcoda.woofwoofstores.R;
import com.inspiredcoda.woofwoofstores.model.CartItem;
import com.inspiredcoda.woofwoofstores.model.Dog;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private static final String TAG = "CartAdapter";

    private List<CartItem> cartItems = new ArrayList<>();

    public CartAdapter(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewer = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cart_item_layout, parent, false);
        return new CartViewHolder(viewer);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        holder.cartItemName.setText(cartItems.get(position).getName());
        holder.cartItemPrice.setText(String.valueOf(cartItems.get(position).getPrice()));
        holder.cartItemQuantity.setText(String.valueOf(cartItems.get(position).getQuantity()));

        Log.d(TAG, "onBindViewHolder: Cart Item Price: "+ cartItems.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    class CartViewHolder extends RecyclerView.ViewHolder{

        TextView cartItemName, cartItemPrice, cartItemQuantity;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);

            cartItemName = itemView.findViewById(R.id.cart_item_name);
            cartItemPrice = itemView.findViewById(R.id.cart_item_price);
            cartItemQuantity = itemView.findViewById(R.id.cart_item_quantity);

        }
    }
}
