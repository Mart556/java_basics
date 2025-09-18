 class BoundedCounter2 {
    private int value;
    private int upperLimit;

    public BoundedCounter2(int upperLimit) {
        this.upperLimit = upperLimit;
    }

    public void next() {
        this.value++;

        if (this.value > this.upperLimit) {
            this.value = 0;
        }
    }

    public String toString() {
        return String.format("%d", this.value);
    }
}

public class Exercise78 {
    public static void main(String[] args) {
        BoundedCounter2 counter = new BoundedCounter2(4);
        System.out.println("Value at start: " + counter );

        int i = 0;
        while ( i < 10) {
            counter.next();
            System.out.println("Value: " + counter );
            i++;
        }
    }
}
