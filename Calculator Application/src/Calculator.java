public class Calculator {
    StringBuilder value;

    public Calculator() {
        value = new StringBuilder();
    }

    public void clear() {
        value = new StringBuilder();
        display();
    }

    public void backSpace() {
        value.deleteCharAt(value.length() - 1);
        display();
    }

    public void append(char val) {
        int n = value.length();
        if (value.length() > 0 && !Character.isDigit(value.charAt(n - 1)) && !Character.isDigit(val)) {
            value.deleteCharAt(n - 1);
        }
        value.append(val);
        display();
    }

    public void evaluate() {
        int result = 0;
        char prevOp = ' ';

        int currNum = 0;
        for (char digit : value.toString().toCharArray()) {
            if (Character.isDigit(digit)) {
                currNum = currNum * 10 + (digit - '0');
            } else {
                result = perform(result, currNum, prevOp);
                prevOp = digit;
                currNum = 0;
            }
        }
        result = perform(result, currNum, prevOp);

        value = new StringBuilder(String.valueOf(result));
        display();
    }

    private int perform(int result, int currNum, char operand) {
        switch (operand) {
            case ' ':
                result = currNum;
                break;
            case '+':
                result += currNum;
                break;
            case '-':
                result -= currNum;
                break;
            case '*':
                result *= currNum;
                break;
            case '/':
                if (currNum == 0) {
                    result = 0;
                } else {
                    result /= currNum;
                }
                break;
            default:
                break;
        }
        return result;
    }

    public void display() {
        char[][] symbols = {
                { 'C', 'X', '%', '/' },
                { '7', '8', '9', '*' },
                { '4', '5', '6', '-' },
                { '1', '2', '3', '+' },
                { ' ', '0', ' ', '=' }
        };

        System.out.println("-------------------------");
        System.out.println("|      My Calculator    |");
        System.out.println("-------------------------");
        System.out.print("|");
        for (int i = 0; i < 23 - value.length(); i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < value.length(); i++) {
            System.out.print(value.charAt(i));
        }
        System.out.println("|");
        System.out.println("-------------------------");

        for (int i = 0; i < symbols.length; i++) {
            System.out.print("|");
            for (int j = 0; j < symbols[i].length; j++) {
                System.out.printf(" %3s |", symbols[i][j]);
            }
            System.out.println();
            System.out.println("-------------------------");
        }

    }
}
