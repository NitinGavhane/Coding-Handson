package com.maveric.productms;

public class Product implements Cloneable {
    private long id;
    private String name;
    private double price;
    private String category;
    private String manufacturedBy;
    public Product(long id,String name, double price, String category, String manufacturedBy){
        this.id=id;
        this.category=category;
        this.name=name;
        this.price=price;
        this.manufacturedBy=manufacturedBy;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getManufacturedBy() {
        return manufacturedBy;
    }

    public void setManufacturedBy(String manufacturedBy) {
        this.manufacturedBy = manufacturedBy;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", manufacturedBy='" + manufacturedBy + '\'' +
                '}';
    }
}
