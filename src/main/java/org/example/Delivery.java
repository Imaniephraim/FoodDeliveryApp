package org.example;

public class Delivery {
    //attributes
    private String location;
    private double cost;

    //constructor
    public Delivery(String location, double cost){
        this.location = location;
        this.cost = cost;
    }

    public String getLocation() {
        return location;
    }

    public double getCost() {
        return cost;
    }
}
