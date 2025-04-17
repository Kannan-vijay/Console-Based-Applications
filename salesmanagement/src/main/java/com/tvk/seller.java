package com.tvk;

public class seller {
    private int id;
    private String name;
    private String place;
    private float totalAmount;
    private float paidAmount;
    private static int automaticId=1;
    public seller(String name,String place){
        this.id=automaticId;
        this.name=name;
        this.place=place;
        this.totalAmount=0;
        this.paidAmount=0;
        automaticId++;
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
    public float getTotaltransactionAmount(){
        return this.totalAmount;
    }
    public float getTotalPaidAmount(){
        return this.paidAmount;
    }
    public float getRemainingAmount(){
        return totalAmount-paidAmount;
    }
    public void addAmount(float amount){
        totalAmount+=amount;
    }
    public void paying(float amount){
        paidAmount+=amount;
        shop.updateEarnings(amount);
    }
    @Override
    public String toString() {
        return  id + "\t" + name + "\t" + place + "\t\t" + totalAmount
                + "\t\t\t" + paidAmount +"\t\t\t"+(totalAmount-paidAmount);
    }
}
