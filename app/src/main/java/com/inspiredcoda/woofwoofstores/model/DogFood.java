package com.inspiredcoda.woofwoofstores.model;

public class DogFood {

    private String foodName;
    private String price;
    private int foodImage;


//    public DogFood(int price, int foodImage) {
//        this.price = String.valueOf(price);
//        this.foodImage = foodImage;
//    }


    public DogFood(String foodName, float price, int foodImage) {
        this.foodName = foodName;
        this.price = String.valueOf(price);
        this.foodImage = foodImage;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setPrice(float price) {
        this.price = String.valueOf(price);
    }

    public String getPrice() {
        return "$"+price;
    }

    public void setPrice(int cost) {
        this.price = String.valueOf(cost);
    }

    public int getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(int foodImage) {
        this.foodImage = foodImage;
    }
}
