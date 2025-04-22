package com.invoice;

public class Customer {
    String customerId;
    String name;
    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }
    @Override
    public String toString() {
        return customerId + "\t\t" + name;
    }
}

