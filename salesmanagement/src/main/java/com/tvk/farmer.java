package com.tvk;

import java.util.ArrayList;
import java.util.Scanner;

public class farmer {
    private int id;
    private String name;
    private String place;
    private String date;
    private float totalAmount;
    private boolean paid;
    private ArrayList<Integer> quantityList;
    private ArrayList<Integer> amountList;
    private float commisionAmount;
    private int advance;
    private int labourWages;
    private static int automaticId=1;
    public farmer(String name, String place, String date) {
        this.id = automaticId;
        this.name = name;
        this.place = place;
        this.date = date;
        this.totalAmount=0;
        this.paid=false;
        quantityList = new ArrayList<>();
        amountList = new ArrayList<>();
        this.commisionAmount = 0;
        this.advance = 0;
        this.labourWages = 0;
    }
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getPlace(){
        return this.place;
    }
    public float getAmount(){
        return this.totalAmount;
    }
    public void paying(float amount){
        if(!paid){
            paid=true;
            shop.updateExpences(amount);
        }
        else{
            System.out.println("Already Paid");
        }
    }



    public String getDate() {
        return date;
    }
    public void farmerBilling(farmer farmer,Scanner sc){
        System.out.print("Enter the Total Quantity : \n");
        int quantity=sc.nextInt();
        labourWages=5*quantity;
        System.out.println("Enter the Amount and SubQuantity one by one in Following Order");
        System.out.println(" Amount | Quantity ");
        while (quantity > 0) {
            int amount = sc.nextInt();
            amountList.add(amount);
            int quant = sc.nextInt();
            quantityList.add(quant);
            totalAmount += (amount*quant);
            quantity-=quant;
        }
        commisionAmount=(totalAmount/10);
        System.out.println("Enter the Advance Amount (AD) : ");
        advance=sc.nextInt();


        System.out.println("--------------------Your Bill Details ---------------------");
        System.out.println("Name : "+farmer.getName());
        System.out.println("Place : "+farmer.getPlace());
        System.out.println(" Price\tQuantity\tTotal ");
        for (int i = 0; i < quantityList.size(); i++) {
            System.out.println(amountList.get(i)+"\t\t"+quantityList.get(i)+"\t"+(amountList.get(i)*quantityList.get(i)));
        }
        System.out.println(" Total Amount \t\t"+totalAmount);
        totalAmount-=(commisionAmount+labourWages+advance);
        System.out.println("commision Amount :"+commisionAmount);
        System.out.println("Advance Amount   :"+advance);
        System.out.println("Labour Wages     :"+labourWages);
        System.out.println("Remaining Total Amount : "+totalAmount);
    }

    public void displayBillDetails(){
        System.out.println("--------------------Your Bill Details ---------------------");
        System.out.println("Name : "+this.getName());
        System.out.println("Place : "+this.getPlace());
        System.out.println(" Price \tQuantity\tTotal ");
        int totalQuantity=0;
        for (int i = 0; i < quantityList.size(); i++) {
            System.out.println(amountList.get(i)+"\t\t"+quantityList.get(i)+"\t"+(amountList.get(i)*quantityList.get(i)));
            totalQuantity+=quantityList.get(i);
        }
        System.out.println("Total Quantity : "+totalQuantity);
        System.out.println(" Total Amount \t\t"+totalAmount);
        System.out.println("commision Amount :"+commisionAmount);
        System.out.println("Advance Amount   :"+advance);
        System.out.println("Labour Wages     :"+labourWages);
        System.out.println("Remaining Total Amount : "+totalAmount);
    }


    @Override
    public String toString() {
        return  id + "\t" + name + "\t" + place + "\t" + date + "\t"
                + totalAmount + "\t\t" + paid;
    }
    
}
