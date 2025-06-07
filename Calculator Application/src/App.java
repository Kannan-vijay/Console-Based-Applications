import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Calculator myCalculator = new Calculator();
        myCalculator.display();
        while (true) {
            System.out.println("Enter 'E' To Exit...");
            System.out.println("Enter the Value:");
            char value = sc.next().charAt(0);
            if (value == 'E' || value == 'e') {
                System.out.println("Exiting...!!!");
                break;
            }

            if (Character.isDigit(value) || value == '+' || value == '-' || value == '*' || value == '/') {
                myCalculator.append(value);
            } else {
                switch (value) {
                    case 'C':
                        myCalculator.clear();
                        break;
                    case 'c':
                        myCalculator.clear();
                        break;
                    case 'X':
                        myCalculator.backSpace();
                        break;
                    case 'x':
                        myCalculator.backSpace();
                        break;
                    case '=':
                        myCalculator.evaluate();
                        break;

                    default:
                        System.out.println("Enter Correct value..!!");
                        break;
                }
            }

        }
        sc.close();

    }
}
