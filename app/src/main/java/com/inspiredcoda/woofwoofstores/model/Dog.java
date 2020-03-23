package com.inspiredcoda.woofwoofstores.model;

public class Dog {

    private String name;
    private String sex;
    private String ageInMonths;
    private String background;
    private String location;
    private int dogImage;
    private double price;


    public Dog(String name, String sex, int ageInMonths, int dogImage, String background, String location, double price) {
        this.name = name;
        this.sex = sex;
        this.ageInMonths = String.valueOf(ageInMonths);
        this.dogImage = dogImage;
        this.background = background;
        this.location = location;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAgeInMonths() {
        return ageInMonths;
    }

    public void setAgeInMonths(int ageInMonths) {
        this.ageInMonths = ageInMonths+ "months";
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getDogImage() {
        return dogImage;
    }

    public void setDogImage(int dogImage) {
        this.dogImage = dogImage;
    }

    public String getPrice() {
        return "$"+price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
