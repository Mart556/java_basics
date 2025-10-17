import java.util.Scanner;

public class Exercise18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type the points [0-60]: ");
        int points = scanner.nextInt();
        int grade;

        if (points < 0 || points > 60) {
            System.out.println("Invalid points. Please enter a value between 0 and 60.");
            scanner.close();
            return;
        }

        if (points <= 29) {

            System.out.println("Grade: failed");
        } else if (points <= 34) {
            grade = 1;
            System.out.println("Grade: " + grade);
        } else if (points <= 39) {
            grade = 2;
            System.out.println("Grade: " + grade);
        } else if (points <= 44) {
            grade = 3;
            System.out.println("Grade: " + grade);
        } else if (points <= 49) {
            grade = 4;
            System.out.println("Grade: " + grade);
        } else { // 50-60
            grade = 5;
            System.out.println("Grade: " + grade);
        }

        scanner.close();
    }
}
