package com.traintickets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TicketHandler {
    private int ticketId = 1;
    private int passengerId = 1;
    private ArrayList<String> availableBeds = new ArrayList<>(Arrays.asList(new String[]{"L","M","U"}));
    private ArrayList<passenger> bookedTicketList = new ArrayList<>();
    private Queue<passenger> RACTicketQueue = new LinkedList<>();
    private Queue<passenger> waitingListQueue = new LinkedList<>();
    passenger passenger;
    public void ticketBooking(Scanner sc){
        System.out.println("Enter the Name :");
        String name = sc.nextLine();
        System.out.println("Enter the Age :");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the Gender(Male / Female):");
        String gender = sc.nextLine();
        gender=gender.toLowerCase();
        System.out.println("Enter the Bed Prefference (L/M/U):");
        String bedpreff = sc.nextLine();
        bedpreff = bedpreff.toUpperCase();
        if(availableBeds.size()==0){
            addToRacTicket(name,age,gender,bedpreff);
            return;
        }
        String alootedBed = getAvailableBed(age, gender, bedpreff);
        availableBeds.remove(alootedBed);
        passenger = new passenger("P"+passengerId++, name, age, gender, "T"+ticketId++, bedpreff, alootedBed);
        bookedTicketList.add(passenger);
        System.out.println("Ticket Was Booked..");
        System.out.println("Ticket Details");
        System.out.println(passenger);
    }

    public void ticketCancellation(Scanner sc){
        System.out.println("Enter the Ticket Id :");
        String ticketId = sc.nextLine();
        int idx = 0;
        for (passenger passenger : bookedTicketList) {
            if(passenger.ticketId.equals(ticketId)){
                availableBeds.add(passenger.allotedBed);
                break;
            }
            idx++;
        }
        bookedTicketList.remove(idx);
        if(RACTicketQueue.size()!=0){
            passenger passenger = RACTicketQueue.poll();
            passenger.allotedBed = getAvailableBed(passenger.age, passenger.gender, passenger.bedPrefference);
            availableBeds.remove(passenger.allotedBed);
            bookedTicketList.add(passenger);
            System.out.println("RAC ticket state Ticket "+passenger.ticketId + " was Added to Booked List");
        }
        if (waitingListQueue.size()!=0) {
            passenger passenger = waitingListQueue.poll();
            passenger.allotedBed = "RAC";
            RACTicketQueue.offer(passenger);
            System.out.println("Waiting list Ticket "+passenger.ticketId +"Was Added to RAC List");
        }
        System.out.println("Ticket Was Cancelled for Ticket Id :"+ticketId);
    }

    private void addToRacTicket(String name,int age,String gender,String bedpreff){
        if(RACTicketQueue.size()==1){
            addToWaitingList(name,age,gender,bedpreff);
            return;
        }
        passenger = new passenger("P"+passengerId++, name, age, gender, "T"+ticketId++, bedpreff, "RAC");
        RACTicketQueue.offer(passenger);
        System.out.println("Ticket Was in the RAC Queue....");
        System.out.println("Ticket Details :"+passenger);
    }

    private void addToWaitingList(String name,int age,String gender,String bedpreff){
        if(waitingListQueue.size()==1){
            System.out.println("No Tickets Available");
            return;
        }
        passenger = new passenger("P"+passengerId++, name, age, gender, "T"+ticketId++, bedpreff, "Waiting List");
        waitingListQueue.offer(passenger);
        System.out.println("Ticket Was in the Waiting List");
        System.out.println("Ticket Details :"+passenger);
    }

    private String getAvailableBed(int age,String gender,String bedpreff){
        if((age>40 || gender.equals("female")) && availableBeds.contains("L")){
            return "L";
        }
        if(availableBeds.contains(bedpreff)){
            return bedpreff;
        }
        return availableBeds.get(0);
    }
    public void displayBookedTicketDetails(){
        if(bookedTicketList.size()==0){
            System.out.println("No Ticket Was Booked");
            return;
        }
        for (passenger passenger : bookedTicketList) {
            System.out.println(passenger);
        }
    }
    public void displayAvailableTickets(){
        System.out.println("Available Tickets :" + availableBeds.size());
        System.out.println("Available RAC Tickets :" + (1-RACTicketQueue.size()));
        System.out.println("Available Waiting List Tickets :" +(1-waitingListQueue.size()));
    }
    public void displayRACTicketDetails(){
        if (RACTicketQueue.size()==0) {
            System.out.println("No RACTicket was booked");
            return;
        }
        for (passenger passenger : RACTicketQueue) {
            System.out.println(passenger);
        }
    }
    public void displayWaitingTicketDetails(){
        if (waitingListQueue.size()==0) {
            System.out.println("No Ticktes in Waiting List");
            return;
        }
        for (passenger passenger : waitingListQueue) {
            System.out.println(passenger);
        }
    }

}
