package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "itemname")
    private String name;

    @Column(name = "price")
    private int price;

    @Column(name = "availability")
    private boolean availability;

    @Column(name = "quantity")
    private float quantity;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public float getQuantity() {
        return quantity;
    }

    public int getId() {
        return id;
    }

    public boolean getAvailability() {
        return availability;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }
}
