package expenses;

import java.util.ArrayList;
import java.util.HashMap;

public class manage {
    ArrayList<expense> expenses;
    private int income;
    private static int automaticId=1;
    private int totalExpense;
    HashMap<String,Integer> map;
    public manage(int income) {
        this.expenses = new ArrayList<>();
        this.income = income;
        map=new HashMap<>();
        totalExpense=0;
    }
    public void addExpense(int amount,String type,String date){
        if(income-amount<0){
            System.out.println("Your Monthly Budget Limit will be Exceeded !!!!!");
        }
        expense neweExpense=new expense(automaticId++,amount,type,date);
        expenses.add(neweExpense);
        if(map.containsKey(type)){
            map.put(type,map.get(type)+amount);
        }
        else{
            map.put(type, amount);
        }
        income-=amount;
        totalExpense+=amount;
    }
    public void showAllDetails(){
        System.out.println("\nId\tDate\tAmount\tType");
        for (expense i : expenses) {
            System.out.println(i.toString());
        }
        System.out.println("\nTotal Expense Amount Will Be "+ totalExpense);
    }
    public void showDetailsByDate(String date){
        int total=0;
        System.out.println("\nId\tDate\tAmount\tType");
        for (expense i : expenses) {
            if(i.date.equals(date)){
                System.out.println(i.toString());
                total+=i.amount;
            }
                
        }
        System.out.println("\nTotal Expense Amount Will Be "+ total);
    }
    public void showDetailsByCategory(){
        System.out.println("\n Expence Category \t Amount");
        for(var i:map.entrySet()){
            System.out.printf("%-20s \t %5d%n", i.getKey(), i.getValue());
        }
        System.out.println("\nTotal Expense Amount Will Be "+ totalExpense);
    }
}
