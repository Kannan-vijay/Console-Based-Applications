import java.util.Scanner;

public class app {
    public static void main(String[] args) {
        calenderHandler handler = new calenderHandler();
        int date,month,year,Choice;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n\n\n-----------------------------------------------------");
            System.out.println("|                 Calender Application               |");
            System.out.println("------------------------------------------------------");
            System.out.println("1.View the Day of the Date.\n2.See the Calender By month and Year.\n3.See current Calender.\n4.Exit");
            System.out.println("\nEnter Your Choice :");
            Choice = sc.nextInt();
            if(Choice == 4){
                System.out.println("Exiting....");
                break;
            }
            switch (Choice) {
                case 1:
                    System.out.println("Enter the Date Month Year (DD MM YYYY) :");
                    date = sc.nextInt();
                    month = sc.nextInt();
                    year = sc.nextInt();
                    System.out.println("The Day of the Date is :"+handler.calculateDay(date, month, year));
                    break;
                case 2:
                    System.out.println("Enter the Month and year (MM YYYY) :");
                    month = sc.nextInt();
                    year = sc.nextInt();
                    handler.setMonthYear(month, year);
                    handler.displayCalender();
                    while (true) {
                        System.out.println("\n1.Prev\n2.Next\n3.Exit");
                        Choice = sc.nextInt();
                        if(Choice == 3){
                            break;
                        }
                        switch (Choice) {
                            case 1:
                                handler.decreamentMonth();
                                handler.displayCalender();
                                break;
                            case 2:
                                handler.increamentMonth();
                                handler.displayCalender();
                                break;
                            default:
                                System.out.println("Enter the Correct Choice");
                                break;
                        }
                    }
                    break;
                case 3:
                    handler.setMonthYear(4, 2025);
                    handler.displayCalender();
                    while (true) {
                        System.out.println("\n1.Prev\n2.Next\n3.Exit");
                        Choice = sc.nextInt();
                        if(Choice == 3){
                            break;
                        }
                        switch (Choice) {
                            case 1:
                                handler.decreamentMonth();
                                handler.displayCalender();
                                break;
                            case 2:
                                handler.increamentMonth();
                                handler.displayCalender();
                                break;
                            default:
                                System.out.println("Enter the Correct Choice");
                                break;
                        }
                    }
                    break;
                default:
                    System.out.println("Enter the Correct option.");
                    break;
            }
        }
        sc.close();
        
    }
}
