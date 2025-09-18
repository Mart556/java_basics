import java.util.Scanner;

public class Exercise14 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Type a number: ");
        int number = reader.nextInt();

        if (number > 0) {
            System.out.println("Your number is positive!");
        } else {
            System.out.println("Your number is negative!");
        }
    }
}
