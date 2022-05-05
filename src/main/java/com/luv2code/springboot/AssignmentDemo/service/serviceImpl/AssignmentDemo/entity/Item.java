package com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.entity;

import lombok.Data;

import javax.persistence.*;

import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "items")
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    public Item(int id) {
        this.id = id;
    }
    @Column(name = "vendor_id")
    private int vendorId;

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public Item(int id, String itemName, String itemDiscription, int price, int quantity) {
        this.id = id;
        this.itemName = itemName;
        this.itemDiscription = itemDiscription;
        this.price = price;
        this.quantity = quantity;
    }

    @Column(name = "item_name")
    @NotEmpty(message = "please enter first name")
    private String itemName;


    @Column(name = "item_discription")
    @NotEmpty(message = "please enter first name")
    private String itemDiscription;



    @Column(name = "price")
    private int price;
    @Column(name = "quantity")
    private int quantity;
    public Item() {}

    public Item(String itemName, String itemDiscription, int price, int quantity) {
        this.itemName = itemName;
        this.itemDiscription = itemDiscription;
        this.price = price;
        this.quantity = quantity;
    }
    public Item(String itemName, String itemDiscription, int price, int quantity,int vendorId) {
        this.itemName = itemName;
        this.itemDiscription = itemDiscription;
        this.price = price;
        this.quantity = quantity;
        this.vendorId=vendorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDiscription() {
        return itemDiscription;
    }

    public void setItemDiscription(String itemDiscription) {
        this.itemDiscription = itemDiscription;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
