import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        LiftHandler handler = new LiftHandler();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n\n\n---------------------------------------------------");
            System.out.println("|                 Lift Service                    |");
            System.out.println("---------------------------------------------------");
            System.out.println("Enter (-1) for exit");
            System.out.println("\n Enter the From Floor :");
            int from = sc.nextInt();
            sc.nextLine();
            if (from == -1) {
                System.out.println("Exiting....");
                break;
            }
            System.out.println("Enter the To floor :");
            int to = sc.nextInt();
            sc.nextLine();
            if (from > 10 || to > 10) {
                System.out.println("Enter the Corrrect Floor");
            }
            handler.assignLift(from, to);
        }
        sc.close();
    }
}
