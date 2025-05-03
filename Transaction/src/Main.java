import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        TransactionHandler handler = new TransactionHandler();
        Scanner sc = new Scanner(System.in);
        String var;
        int value;
        while (true) {
            System.out.println("-----------------------------------------------------");
            System.out.println("|                    Transactions                    |");
            System.out.println("------------------------------------------------------");
            System.out.println("1.SET\n2.GET\n3.UNSET\n4.COUNT\n5.BEGIN\n6.ROLL BACK\n7.COMMIT\n8.EXIT");
            System.out.println("\nEnter Your Choice :");
            int choice = sc.nextInt();
            sc.nextLine();
            if(choice == 8){
                System.out.println("Exiting...");
                break;
            }
            switch (choice) {
                case 1:
                    System.out.println("Enter the Variable Name :");
                    var = sc.nextLine();
                    System.out.println("Enter the Value :");
                    value = sc.nextInt();
                    sc.nextLine();
                    handler.set(var, value);
                    break;
                case 2:
                    System.out.println("Enter the Variable Name :");
                    var = sc.nextLine();
                    if(handler.get(var)==-1){
                        System.out.println("NULL");
                        break;
                    }
                    System.out.println(handler.get(var));   
                    break;
                case 3:
                    System.out.println("\nEnter the Variable Name :");
                    var = sc.nextLine();
                    handler.unset(var);
                    break;
                case 4:
                    System.out.println("Enter the Value to count :");
                    value = sc.nextInt();
                    sc.nextLine();
                    System.out.println(handler.count(value));
                    break;
                case 5:
                    handler.begin();
                    System.out.println("Clear All the records..");
                    System.out.println("Begining the New Transaction....");
                    break;
                case 6:
                    System.out.println("Roll Back All the records..");
                    handler.rollBack();
                    break;
                case 7:
                    System.out.println("Commit All the Changes..");
                    handler.commit();
                    break;
                default:
                    System.out.println("Enter the correct option.");
                    break;
            }
        }
        sc.close();
    }
}
