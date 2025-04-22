package com.invoice;

import java.util.ArrayList;

class Item {
    String name;
    int quantity;
    int price;
    public Item(String name, int quantity, int price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    @Override
    public String toString() {
        return name + "\t" + quantity + "\t\t" + price;
    }
}
public class Invoice {
    String invoiceId;
    String customerId;
    ArrayList<Item> items;
    public Invoice(String invoiceId, String customerId) {
        this.invoiceId = invoiceId;
        this.customerId = customerId;
        items = new ArrayList<>();
    }
    public void addItem(String name,int quantity,int price){
        Item newItem = new Item(name, quantity, price);
        items.add(newItem);
        System.out.println("Item Added to the Invoice Id "+invoiceId + " Sucessfully.....");
    }
    @Override
    public String toString() {
        return invoiceId + "\t\t" + customerId;
    }
    public void displayItems(){
        int total = 0;
        System.out.println("Name\tQuantity\tPrice");
        for (Item item : items) {
            System.out.println(item);
            total+=(item.price*item.quantity);
        }
        System.out.println("\tTotal Amount : "+total);
    }
}
