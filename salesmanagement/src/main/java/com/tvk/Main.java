package com.tvk;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        shop kannan = new shop();
        while (true) {
            System.out.println("\n\n\n--------------------------------------------------------------");
            System.out.println("|               Welcome to Kannan Shop                       |");
            System.out.println("--------------------------------------------------------------");
            System.out.println(" 1. Owner \n 2. Accounter \n 3. Seller \n 4. Farmer \n 5. Exit");
            System.out.println("\nPlease Enter Your Position Number:");
            
            int Position = sc.nextInt();
            sc.nextLine();

            if (Position == 5) {
                break;
            }
            switch (Position) {
                case 1:
                    while (true) {
                        System.out.println("\n\n\n--------------------------------------------------------------");
                        System.out.println("|               Owner Functionalities                        |");
                        System.out.println("--------------------------------------------------------------");
                        System.out.println("\n\n1. Seller Details\n2. Farmer Details\n3. Shop Details\n4. Bill Paying\n5. Back");
                        System.out.println("Enter Your choice Number to see Details: ");
                        
                        int choice = sc.nextInt();
                        sc.nextLine();

                        if (choice == 5) {
                            break;
                        }
                        switch (choice) {
                            case 1:
                                kannan.showSellerDetails();
                                break;
                            case 2:
                                kannan.showFarmerDetails();
                                break;
                            case 3:
                                kannan.showShopDetails();
                                break;
                            case 4:
                                System.out.println("Enter the Name of the Farmer: ");
                                String name = sc.nextLine();
                                System.out.println("Enter the place of the Farmer:");
                                String place = sc.nextLine();
                                System.out.println("Enter the Date of the bill: ");
                                String date = sc.nextLine();
                                farmer farmer = kannan.findFarmer(name, place, date);
                                if (farmer == null) {
                                    System.out.println("There is No farmer exists with this name. Enter the Details Properly");
                                } else {
                                    farmer.paying(farmer.getAmount());
                                    System.out.println("\n Bill payment Sucessfull...");
                                }
                                break;
                            default:
                                System.out.println("Enter the Correct Choice");
                                break;
                        }
                    }
                    break;
                case 2:
                    while (true) {
                        System.out.println("\n\n\n--------------------------------------------------------------");
                        System.out.println("|               Accounter Functionalities                    |");
                        System.out.println("--------------------------------------------------------------");
                        System.out.println("\n1. Farmer Billing \n2. Seller Billing \n3. Back");
                        System.out.println("\nEnter Your Choice");
                        
                        int choice = sc.nextInt();
                        sc.nextLine();

                        if (choice == 3) {
                            break;
                        }
                        switch (choice) {
                            case 1:
                                System.out.println("\nEnter the Name of the Farmer:");
                                String name = sc.nextLine();
                                System.out.println("Enter the place of the Farmer:");
                                String place = sc.nextLine();
                                System.out.println("Enter the Date: ");
                                String date = sc.nextLine();
                                farmer newFarmer = new farmer(name, place, date);
                                newFarmer.farmerBilling(newFarmer,sc);
                                kannan.addFarmer(newFarmer);
                                break;
                            case 2:
                                System.out.println("\nEnter the Name of the Seller:");
                                String Name = sc.nextLine();
                                System.out.println("\nEnter the place of the Seller:");
                                String Place = sc.nextLine();
                                System.out.println("Seller is New to our Shop or Not (Y/N):");
                                seller newSeller;
                                if (sc.nextLine().equalsIgnoreCase("Y")) {
                                    newSeller = new seller(Name, Place);
                                } else {
                                    newSeller = kannan.findSeller(Name, Place);
                                    if (newSeller == null) {
                                        System.out.println("There is No Seller exists with this name. Enter the Details Properly");
                                        break;
                                    }
                                }
                                sellerBilling(newSeller,sc);
                                kannan.addSellers(newSeller);
                                break;
                            default:
                                System.out.println("Enter the Correct option: ");
                                break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("\nEnter your Name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter Your Place: ");
                    String place = sc.nextLine();
                    while (true) {
                        System.out.println("\n\n\n--------------------------------------------------------------");
                        System.out.println("|               Seller  Functionalities                      |");
                        System.out.println("--------------------------------------------------------------");
                        System.out.println("\n1. See Your Details\n2. Bill Payment\n3. Back");
                        System.out.println("\nEnter your Choice:");
                        
                        int choice = sc.nextInt();
                        sc.nextLine();

                        if (choice == 3) {
                            break;
                        }
                        switch (choice) {
                            case 1:
                                seller seller = kannan.findSeller(name, place);
                                if (seller == null) {
                                    System.out.println("There is No Seller exists with this name. Enter the Details Properly");
                                } else {
                                    System.out.println("\nId\tName\tplace\t\tTotal Transaction Amount\tTotal Paid Amount\t Remaining Amount");
                                    System.out.println(seller.toString());
                                }
                                break;
                            case 2:
                                System.out.println("Enter the Amount to pay: ");
                                int amount = sc.nextInt();
                                sc.nextLine();
                                
                                seller currSeller = kannan.findSeller(name, place);
                                if (currSeller == null) {
                                    System.out.println("There is No Seller exists with this name. Enter the Details Properly");
                                } else {
                                    currSeller.paying(amount);
                                    System.out.println("Your amount will be Paid");
                                }
                                break;
                            default:
                                System.out.println("Enter the Correct option!");
                                break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("\nEnter Your Name:");
                    String farmername = sc.nextLine();
                    System.out.println("Enter Your place:");
                    String farmerPlace = sc.nextLine();
                    System.out.println("Enter the Date of your bill:");
                    String date = sc.nextLine();
                    while (true) {
                        System.out.println("\n\n\n--------------------------------------------------------------");
                        System.out.println("|               Farmer Functionalities                       |");
                        System.out.println("--------------------------------------------------------------");
                        System.out.println("\n1. See the Bill Details\n2. See Bill Status \n3.Back");
                        
                        int choice = sc.nextInt();
                        sc.nextLine();

                        if (choice == 3) {
                            break;
                        }
                        switch (choice) {
                            case 1:
                                farmer farmer = kannan.findFarmer(farmername, farmerPlace, date);
                                if (farmer == null) {
                                    System.out.println("There is No Farmer exists with this name. Enter the Details Properly");
                                } else {
                                    farmer.displayBillDetails();
                                }
                                break;
                            case 2:
                                farmer currfarmer = kannan.findFarmer(farmername, farmerPlace,date);
                                if (currfarmer == null) {
                                    System.out.println("There is No Farmer exists with this name. Enter the Details Properly");
                                } else {
                                    System.out.println("\nId\tName\tplace\t\tDate\t\tTotalAmout\tPaymentStatus");
                                    System.out.println(currfarmer.toString());
                                }
                                break;
                            default:
                                System.out.println("Enter the Correct option!");
                                break;
                        }
                    }
                    break;
                default:
                    System.out.println("Enter the correct Number of your Position");
                    break;
            }
        }
        sc.close();
    }

    public static void sellerBilling(seller seller,Scanner sc) {
        System.out.print("Enter the Total Quantity: \n");
        int quantity = sc.nextInt();
        sc.nextLine();

        int labourWages = 10 * quantity;
        System.out.println("Enter the Amount and SubQuantity one by one in Following Order");
        System.out.println(" Amount | Quantity ");
        
        ArrayList<Integer> quantityList = new ArrayList<>();
        ArrayList<Integer> amountList = new ArrayList<>();
        float totalAmount = 0;
        float discount = 0;

        while (quantity > 0) {
            int amount = sc.nextInt();
            int quant = sc.nextInt();
            quantityList.add(quant);
            amountList.add(amount);
            totalAmount += (amount * quant);
            quantity -= quant;
        }
        sc.nextLine();

        System.out.println("If you Are a Regular Customer (Y/N): ");
        boolean regularCustomer = sc.nextLine().equalsIgnoreCase("Y");

        System.out.println("--------------------Your Bill Details ---------------------");
        System.out.println("Name: " + seller.getName());
        System.out.println("Place: " + seller.getPlace());
        System.out.println(" Price\tQuantity\tTotal ");
        
        for (int i = 0; i < quantityList.size(); i++) {
            System.out.println(amountList.get(i) + "\t\t" + quantityList.get(i) + "\t" + (amountList.get(i) * quantityList.get(i)));
        }
        
        System.out.println("Total Amount \t\t" + totalAmount);
        if (regularCustomer) {
            discount = (totalAmount / 100) * 2;
            totalAmount -= discount;
        }
        
        if (regularCustomer)
            System.out.println("\nDiscount Amount \t" + discount);
        
        System.out.println("Labour Wages: \t\t" + labourWages);
        totalAmount += labourWages;
        System.out.println("\nAfter Discount and Wages\nThe Final Amount will be: " + totalAmount);
        
        seller.addAmount(totalAmount);
    }
}
