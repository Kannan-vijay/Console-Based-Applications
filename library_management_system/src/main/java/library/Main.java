package library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryHandler handler = new LibraryHandler();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n\n-------------------------------------------------------------------");
            System.out.println("|                    Library Management System                    |");
            System.out.println("-------------------------------------------------------------------");
            System.out.println("1.Admin\n2.User\n3.Exit");
            System.out.println("Enter Your Role :");
            String role = sc.nextLine();
            if (role.equalsIgnoreCase("exit")) {
                break;
            }
            else if(role.equalsIgnoreCase("admin")){
                System.out.println("Enter the User Name :");
                String userName = sc.nextLine();
                System.out.println("Enter the Password:");
                String password = sc.nextLine();
                if(userName.equals("admin") && password.equals("admin")){
                    System.out.println("Sucessfully Loged In as Admin..\n\n");
                    while (true) {
                        System.out.println("\n\n-----------------------------------------------------------------------------");
                        System.out.println("|                            Admin Functionalities                          |");
                        System.out.println("-----------------------------------------------------------------------------");
                        System.out.println("1.Add Book\n2.Update Book\n3.Remove Book\n4.Add Member\n5.Display All Books");
                        System.out.println("6.Display All Members\n7.Exit");
                        System.out.println("Enter your Choice :");
                        int choice = sc.nextInt();
                        sc.nextLine();
                        if(choice==7){
                            System.out.println("Exiting...");
                            break;
                        }
                        switch (choice) {
                            case 1:
                                handler.addBook(sc);
                                break;
                            case 2:
                                handler.updateBook(sc);
                                break;
                            case 3:
                                handler.removeBook(sc);
                                break;
                            case 4:
                                handler.addMember(sc);
                                break;
                            case 5:
                                handler.displayAllBooks();
                                break;
                            case 6:
                                handler.displayAllMembers();
                                break;
                            default:
                                System.out.println("Enter the Correct option..");
                                break;
                        }
                    }
                    
                }
                else{
                    System.out.println("UserName and Password is Wrong.. Try Again..");
                }
            }
            else{
                System.out.println("Enter the User Name :");
                String userName = sc.nextLine();
                User user = handler.checkMember(userName);
                System.out.println("Sucessfully Loged As User..\n\n");
                while (true) {
                    System.out.println("\n\n----------------------------------------------------------------------------");
                    System.out.println("|                            User Functionalities                          |");
                    System.out.println("----------------------------------------------------------------------------");
                    System.out.println("1.Borrow Book\n2.Return Book\n3.Display All Book\n4.Display All Member\n5.Search Book by Name");
                    System.out.println("6.Search book By Author\n7.Search Book By Genre\n8.View Borrowed Books\n9.Exit");
                    System.out.println("Enter your Choice :");
                    int choice = sc.nextInt();
                    sc.nextLine();
                    if(choice == 9){
                        break;
                    }
                    switch (choice) {
                        case 1:
                            handler.borrowBook(user, sc);
                            break;
                        case 2:
                            handler.returnBook(user, sc);
                            break;
                        case 3:
                            handler.displayAllBooks();
                            break;
                        case 4:
                            handler.displayAllMembers();
                            break;
                        case 5:
                            handler.displayBookByName(sc);
                            break;
                        case 6:
                            handler.displayBookByAuthor(sc);
                            break;
                        case 7:
                            handler.displayBookByGenre(sc);
                            break;
                        case 8:
                            user.displayBorrowedBooks();
                            break;
                        default:
                            System.out.println("Enter the Correct Option");
                            break;
                    }
                }
            }
        }
        
    }
}