package expenses;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Your Monthly Income : ");
        int income=sc.nextInt();
        manage exp=new manage(income);
        while (true) {
            System.out.println("\n1.Add Expense\n2.Show All history\n3.See History By Date\n4.Expence Summary\n5.Exit");
            int choice=sc.nextInt();
            if(choice==5){
                break;
            }
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter the Amount will be Spended :");
                    int amount=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the Category :");
                    String type=sc.nextLine();
                    System.out.println("Enter the Date of the Expense :");
                    String date=sc.nextLine();
                    exp.addExpense(amount, type, date);
                    break;
                case 2:
                    exp.showAllDetails();
                    break;
                case 3:
                    System.out.println("Enter the Date to See the Details : ");
                    String Date=sc.nextLine();
                    exp.showDetailsByDate(Date);
                    break;
                case 4:
                    exp.showDetailsByCategory();
                    break;
                default:
                    System.out.println("Enter the Valid option");
                    break;
            }
        }
        sc.close();
    }
}