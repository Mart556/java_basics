public class Exercise5 {
    public static void main(String[] args) {
        int days = 365;
        int hours = 24;
        int minutes = 60;
        int seconds = 60;

        int secondsInMonth = days * hours * minutes * seconds;

        System.out.println("There are "+ secondsInMonth +" seconds in a year.");
    }
}
