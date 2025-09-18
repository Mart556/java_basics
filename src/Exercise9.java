import java.util.Scanner;

public class Exercise9 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("First number: ");
        int x = Integer.parseInt(reader.nextLine());

        System.out.print("Second number: ");
        int y = Integer.parseInt(reader.nextLine());

        System.out.print("Division of numbers: " + (x / y));
    }
}
