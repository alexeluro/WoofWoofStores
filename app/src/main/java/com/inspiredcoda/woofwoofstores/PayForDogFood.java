package com.inspiredcoda.woofwoofstores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.inspiredcoda.woofwoofstores.model.CartItem;
import com.inspiredcoda.woofwoofstores.ui.cart.CartViewModel;

public class PayForDogFood extends AppCompatActivity implements View.OnClickListener {

    Button addToCart, buyNow, increaseQuantity, reduceQuantity;
    TextView amount, foodName, quantity;
    ImageView foodImage;

    String nameOfFood, amountOfFood;
    int foodResource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_for_dog_food);

        increaseQuantity = findViewById(R.id.increase_quantity);
        reduceQuantity = findViewById(R.id.reduce_quantity);
        foodImage = findViewById(R.id.dog_food_image);
        foodName = findViewById(R.id.pay_for_dog_food_name);
        addToCart = findViewById(R.id.pay_for_dog_food_add_to_cart);
        buyNow = findViewById(R.id.pay_for_dog_food_buy_now);
        amount = findViewById(R.id.pay_for_dog_food_cost);
        quantity = findViewById(R.id.quantity);

        nameOfFood = getIntent().getExtras().getString("food_name");
        amountOfFood = getIntent().getExtras().getString("food_price");
        foodResource = getIntent().getExtras().getInt("food_image");

        foodName.setText(nameOfFood);
        amount.setText(amountOfFood);
        foodImage.setImageResource(foodResource);

        increaseQuantity.setOnClickListener(this);
        reduceQuantity.setOnClickListener(this);
        buyNow.setOnClickListener(this);
        addToCart.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        int quant = Integer.parseInt(quantity.getText().toString());
        switch(view.getId()){
            case R.id.increase_quantity:
                if(quant >= 1){
                    quant = quant + 1;
                    quantity.setText(String.valueOf(quant));
                }
                break;

            case R.id.reduce_quantity:
                if(quant > 1){
                    quant = quant - 1;
                    quantity.setText(String.valueOf(quant));
                }
                break;

            case R.id.pay_for_dog_food_add_to_cart:
                CartManager manager = new CartManager();
                manager.addItemToCart(new CartItem(nameOfFood, Float.parseFloat(amountOfFood.substring(1)), quant));
                Toast.makeText(PayForDogFood.this,
                        "Added Successfully!!\nCart items: "+ manager.getItemsFromCart().size(),
                        Toast.LENGTH_SHORT)
                        .show();
                break;

            case R.id.pay_for_dog_food_buy_now:
                Toast.makeText(this, "Buy now button clicked!!", Toast.LENGTH_SHORT).show();
        }
    }
}
