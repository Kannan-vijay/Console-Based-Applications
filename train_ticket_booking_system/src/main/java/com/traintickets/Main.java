package com.traintickets;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicketHandler handler = new TicketHandler();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n\n-----------------------------------------------------------");
            System.out.println("|                 Train Ticket Booking System              ");
            System.out.println("-----------------------------------------------------------");
            System.out.println("1.Ticket Booking\n2.Ticket Cancellation\n3.View Booked Tickets\n4.View Available Tickets");
            System.out.println("5.veiw RAC Tickets\n6.view WaitingList Tickets\n7.Exit");
            System.out.println("\nEnter your Choice :");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 7) {
                System.out.println("Exiting....");
                break;
            }
            switch (choice) {
                case 1:
                    handler.ticketBooking(sc);
                    break;
                case 2:
                    handler.ticketCancellation(sc);
                    break;
                case 3:
                    handler.displayBookedTicketDetails();
                    break;
                case 4:
                    handler.displayAvailableTickets();
                    break;
                case 5:
                    handler.displayRACTicketDetails();
                    break;
                case 6:
                    handler.displayWaitingTicketDetails();
                    break;
                default:
                    System.out.println("Enter the Correct options");
                    break;
            }
        }
        sc.close();
    }
}