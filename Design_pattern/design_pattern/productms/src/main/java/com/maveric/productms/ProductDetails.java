package com.maveric.productms;

public class ProductDetails {
    private String name;
    private double price;
    public ProductDetails(String name, double price){
        this.name=name;
        this.price=price;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProductDetails{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
