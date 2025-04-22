package com.invoice;

import java.util.ArrayList;
import java.util.Scanner;

public class InvoiceHandler {
    ArrayList<Customer> customers = new ArrayList<>();
    ArrayList<Invoice> invoices = new ArrayList<>();
    public void addcustomer(Scanner sc){
        System.out.println("Enter the unique Customer Id :");
        String customerId = sc.nextLine();
        System.out.println("Enter the Customer Name :");
        String customerName = sc.nextLine();
        Customer customer = new Customer(customerId,customerName);
        customers.add(customer);
        System.out.println("Customer Added Sucessfully..");
    }
    public void addInvoice(Scanner sc){
        System.out.println("Enter the unique Invoice Id :");
        String invoiceId = sc.nextLine();
        System.out.println("Enter the Customer Id :");
        String customerId = sc.nextLine();
        boolean present = false;
        for (Customer customer : customers) {
            if(customer.customerId.equals(customerId)){
                present = true;
            }
        }
        if(!present){
            System.out.println("There is No Customer Present in this Id: "+customerId);
            return;
        }
        Invoice newInvoice = new Invoice(invoiceId, customerId);
        invoices.add(newInvoice);
        System.out.println("Invoice Added SucessFully");
    }
    public void addItemtoinvoice(Scanner sc){
        System.out.println("Enter the Invoice Id :");
        String invoiceId = sc.nextLine();
        Invoice selectedinvoice = null;
        for (Invoice invoice : invoices) {
            if(invoice.invoiceId.equals(invoiceId)){
                selectedinvoice = invoice;
            }
        }
        if(selectedinvoice == null){
            System.out.println("There is No invoice Available in this id: "+invoiceId);
            return;
        }
        System.out.println("Enter the Item Name:");
        String itemName = sc.nextLine();
        System.out.println("Enter the Item Quantity :");
        int itemQuantity = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the Price of the Item");
        int itemPrice = sc.nextInt();
        sc.nextLine();
        selectedinvoice.addItem(itemName, itemQuantity, itemPrice);
    }
    public void displayAllCustomers(){
        System.out.println("CustomerID   CustomerName");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
    public void displayAllInvoices(){
        System.out.println("InvoiceId   CustomerId");
        for (Invoice invoice : invoices) {
            System.out.println(invoice);
        }
    }
    public void displayAllInvoicesOfCustomer(Scanner sc){
        System.out.println("Enter the Customer Id:");
        String customerId = sc.nextLine();
        System.out.println("InvoiceId   CustomerId");
        for (Invoice invoice : invoices) {
            if(invoice.customerId.equals(customerId))
                System.out.println(invoice);
        }
    }
    public void displayFullDetailOfInvoice(Scanner sc){
        System.out.println("Enter the Invoice Id:");
        String invoiceId = sc.nextLine();
        Invoice selectedInvoice = null;
        for (Invoice invoice : invoices) {
            if(invoice.invoiceId.equals(invoiceId)){
                selectedInvoice = invoice;
            }
        }
        if (selectedInvoice == null) {
            System.out.println("There is No invoices present in this Invoice Id :"+invoiceId);
            return;
        }
        selectedInvoice.displayItems();
    }
}
