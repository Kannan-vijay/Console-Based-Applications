package com.invoice;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        InvoiceHandler handler = new InvoiceHandler();
        while (true) {
            System.out.println("\n\n--------------------------------------------------------------");
            System.out.println("|                 Invoice Management System                   |");
            System.out.println("---------------------------------------------------------------");
            System.out.println("1.Add Customer\n2.Add Invoice\n3.Add Item to Invoice\n4.List All Customers");
            System.out.println("5.List All Invoices\n6.List All Invoices of Customer\n7.Display Full Detail of Invoice\n8.Exit");
            System.out.println("\nEnter your Choice :");
            int choice = sc.nextInt();
            sc.nextLine();
            if(choice == 8){
                System.out.println("Exiting.....");
                break;
            }
            switch (choice) {
                case 1:
                    handler.addcustomer(sc);
                    break;
                case 2:
                    handler.addInvoice(sc);
                    break;
                case 3:
                    handler.addItemtoinvoice(sc);
                    break;
                case 4:
                    handler.displayAllCustomers();
                    break;
                case 5:
                    handler.displayAllInvoices();
                    break;
                case 6:
                    handler.displayAllInvoicesOfCustomer(sc);
                    break;
                case 7:
                    handler.displayFullDetailOfInvoice(sc);
                    break;
                default:
                    System.out.println("Enter the Correct Option..");
                    break;
            }
        }
        sc.close();
    }
}