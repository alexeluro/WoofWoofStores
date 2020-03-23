package com.inspiredcoda.woofwoofstores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.inspiredcoda.woofwoofstores.model.CartItem;
import com.inspiredcoda.woofwoofstores.model.Dog;

public class BuyDog extends AppCompatActivity implements View.OnClickListener {

    ImageView dogImage;
    TextView dogBreed, dogName, dogAgeInMonths, dogSex, dogLocation, dogBackground, dogPrice;
    Button buyNow, addToCart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_dog);


        dogImage = findViewById(R.id.buy_dog_image);
        dogBreed = findViewById(R.id.buy_dog_title_breed);
        dogName = findViewById(R.id.buy_dog_name);
        dogAgeInMonths = findViewById(R.id.buy_dog_age);
        dogSex = findViewById(R.id.buy_dog_sex);
        dogLocation = findViewById(R.id.buy_dog_location);
        dogBackground = findViewById(R.id.buy_dog_background);
        dogPrice = findViewById(R.id.buy_dog_cost);
        buyNow = findViewById(R.id.buy_dog_buy_btn);
        addToCart = findViewById(R.id.buy_dog_add_to_cart_btn);

        dogName.setText(String.valueOf(getIntent().getExtras().get("dog_name")));
        dogImage.setImageResource((int)getIntent().getExtras().get("dog_image"));
        dogSex.setText(String.valueOf(getIntent().getExtras().get("dog_sex")));
        dogAgeInMonths.setText(String.valueOf(getIntent().getExtras().get("dog_age")));
        dogLocation.setText(String.valueOf(getIntent().getExtras().get("dog_location")));
        dogBackground.setText(String.valueOf(getIntent().getExtras().get("dog_background")));
        dogPrice.setText(String.valueOf(getIntent().getExtras().get("dog_price")));

        addToCart.setOnClickListener(this);
        buyNow.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        String name, sex, location, background, age, price;
//        int imageResource;
        name = dogName.getText().toString().trim();
        sex = dogSex.getText().toString().trim();
//        location = dogLocation.getText().toString().trim();
//        background = dogBackground.getText().toString().trim();
        price = dogPrice.getText().toString().trim();
        age = dogAgeInMonths.getText().toString().trim();

//        imageResource = Integer.parseInt(dogImage.getBackground().toString());
        switch(view.getId()){
            case R.id.buy_dog_buy_btn:
                Toast.makeText(this, "Buy Now clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buy_dog_add_to_cart_btn:
                CartManager manager = CartManager.getInstance();
                manager.addItemToCart(new CartItem(name, Double.parseDouble(price.substring(1)), 1));
                Toast.makeText(this, "Added to cart Successfully!!!", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
