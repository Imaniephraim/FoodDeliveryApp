package org.example;

public class Food {
    //attributes
    private String name;
    private  double price;

    //constructor
    public Food(String name, double price){
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
