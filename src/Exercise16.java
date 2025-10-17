import java.util.Scanner;

public class Exercise16 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Type a number: ");
        int number = reader.nextInt();

        if (number % 2 == 0) {
            System.out.println("Your number is even!");
        } else {
            System.out.println("Your number is odd!");
        }

        reader.close();
    }
}
