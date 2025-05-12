import java.util.*;

public class main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Character> originalColors = new ArrayList<>();
        initialize(originalColors);
        System.out.println(originalColors);
        ArrayList<Character> inputColors = new ArrayList<>();
        
        while (true) {
            System.out.println("\n\n\nSecret Code : ? ? ? ?   (Four Colors Hidden)");
            System.out.println("Available Colors Are = 'R','B','G','Y','O','V','W'");
            System.out.println("Enter the Four Colors One By One:");
            for (int i = 0; i < 4; i++) {
                char color = sc.next().charAt(0);
                inputColors.add(Character.toUpperCase(color));
            }
            if(checkColor(inputColors, originalColors)){
                System.out.println("\n\nYou Correctly Guess All the Colors..!!!");
                System.out.println("You Wint the Game..");
                break;
            }
            else{
                System.out.println("\nYour Guess is Wrong try another Chance..!!!");
            }
        }
        sc.close();
    }
    static boolean checkColor(ArrayList<Character> inputColors, ArrayList<Character> originalColors){
        int correctChoice = 0;
        int wrongChoice = 0;
        int correctButWrongPos = 0;
        for (int i = 0; i < inputColors.size(); i++) {
            if(inputColors.get(i) == originalColors.get(i)){
                correctChoice++;
            }
            else if(originalColors.contains(inputColors.get(i))){
                correctButWrongPos++;
            }
            else{
                wrongChoice++;
            }
        }
        System.out.println("\n\n"+correctChoice+"  colors in the right position");
        System.out.println(correctButWrongPos+"  colors in the wrong position");
        System.out.println(wrongChoice+"  Wrong Colors");

        return correctChoice == 4;
    }
    static void initialize(ArrayList<Character> colors){
        char[] colorsArray = {'R','B','G','Y','O','V','W'};
        Random random = new Random();
        HashSet<Character> set = new HashSet<>();
        while (set.size()<4) {
            int randomIdx = random.nextInt(7);
            set.add(colorsArray[randomIdx]);
        }
        for (Character color : set) {
            colors.add(color);
        }
    }
}
