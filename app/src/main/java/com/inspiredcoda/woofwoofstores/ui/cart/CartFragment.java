package com.inspiredcoda.woofwoofstores.ui.cart;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.inspiredcoda.woofwoofstores.R;
import com.inspiredcoda.woofwoofstores.adapter.CartAdapter;
import com.inspiredcoda.woofwoofstores.model.CartItem;

import java.util.List;

public class CartFragment extends Fragment implements View.OnClickListener {

    private CartViewModel mViewModel;
    private RecyclerView cartRecyclerView;
    private TextView cashOutAmt;
    private Button cashOutBtn;
    private CartAdapter cartAdapter;

    public static CartFragment newInstance() {
        return new CartFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View viewer = inflater.inflate(R.layout.fragment_cart, container, false);
        cartRecyclerView = viewer.findViewById(R.id.cart_recyclerview);
        cashOutAmt = viewer.findViewById(R.id.cart_total_amt);
        cashOutBtn = viewer.findViewById(R.id.cash_out_btn);


        cashOutBtn.setOnClickListener(this);

        return viewer;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(CartViewModel.class);
        // TODO: Use the ViewModel
        mViewModel.init();
        mViewModel.getCartItems().observe(getViewLifecycleOwner(), new Observer<List<CartItem>>() {
            @Override
            public void onChanged(List<CartItem> cartItems) {
                if (cartAdapter == null){
                    Toast.makeText(getContext(), "Cart Items: "+cartItems.size(), Toast.LENGTH_SHORT).show();
                    cartAdapter = new CartAdapter(cartItems);
                    initRecyclerView();
                    cashOutAmt.setText(sumOfGoods(cartItems));
                }else{
                    cartAdapter.notifyDataSetChanged();
                    cashOutAmt.setText(sumOfGoods(cartItems));
                    Toast.makeText(getContext(), "Cart Items: "+cartItems.size(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initRecyclerView(){
        cartRecyclerView.setAdapter(cartAdapter);
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private String sumOfGoods(List<CartItem> cartItems){
        double total = 0;
        for (CartItem item : cartItems){
            total = total + (item.getPrice() * item.getQuantity());
        }
        return "$"+total;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cash_out_btn:
                Toast.makeText(getContext(), "Cash out Button Clicked", Toast.LENGTH_SHORT).show();
        }
    }
}
