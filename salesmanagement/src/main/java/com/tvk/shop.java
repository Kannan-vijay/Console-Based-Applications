package com.tvk;

import java.util.ArrayList;

public class shop {
    private ArrayList<seller> sellers;
    private ArrayList<farmer> farmers;
    private static float totalEarnings;
    private static float totalExpenses;
    public shop() {
        this.sellers = new ArrayList<>();
        this.farmers = new ArrayList<>();
        totalEarnings=0;
        totalExpenses=0;
    }
    public static void updateEarnings(float amount){
        totalEarnings+=amount;
    }
    public static void updateExpences(float amount){
        totalExpenses+=amount;
    }
    public void addSellers(seller seller){
        sellers.add(seller);
    }
    public void addFarmer(farmer farmer){
        farmers.add(farmer);
    }
    public float getTotalEarnings() {
        return totalEarnings;
    }
    public float getTotalExpenses() {
        return totalExpenses;
    }
    public float getProfit(){
        return totalEarnings-totalExpenses;
    }
    public farmer findFarmer(String name,String place,String date){
        for(farmer i:farmers){
            if(i.getName().equals(name) && i.getPlace().equals(place) && i.getDate().equals(date)){
                return i;
            }
        }
        return null;
    }
    public seller findSeller(String name,String place){
        for(seller i:sellers){
            if(i.getName().equals(name) && i.getPlace().equals(place)){
                return i;
            }
        }
        return null;
    }
    public void showSellerDetails(){
        System.out.println("\nId\tName\tplace\t\tTotal Transaction Amount\tTotal Paid Amount\t Remaining Amount");
        for(seller i:sellers){
            System.out.println(i.toString());
        }
    }
    public void showFarmerDetails(){
        System.out.println("\nId\tName\tplace\t\tDate\t\tTotalAmout\tPaymentStatus");           
        for(farmer i:farmers){
            System.out.println(i.toString());
        }
    }
    public void showShopDetails(){
        System.out.println("\n\n Total Earnings\tTotal Expenses\t Total Profit");
        System.out.println(getTotalEarnings()+"\t\t"+getTotalExpenses()+"\t\t"+getProfit());
        System.out.println("\n Total Farmers Count : "+farmers.size());
        System.out.println("\n Total Seller Count : "+sellers.size());
    }
    
}
