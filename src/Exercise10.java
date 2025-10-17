import java.util.Scanner;

public class Exercise10 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Radius: ");
        int radius = Integer.parseInt(reader.nextLine());

        double x = 2 * Math.PI * radius;

        System.out.print("Circumference of the circle: " + x);

        reader.close();
    }
}
