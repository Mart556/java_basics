class DecreasingCounter {
    private int value;   // object variable that remembers the value of the counter

    public DecreasingCounter(int valueAtStart) {
        this.value = valueAtStart;
    }

    public void printValue() {
        System.out.println("value: " + this.value);
    }

    public void decrease() {
        System.out.println("decrease");
        this.value--;
    }

    public int getValue() {
        return this.value;
    }
}


public class Exercise75 {
    public static void main(String[] args) throws InterruptedException {
        DecreasingCounter counter = new DecreasingCounter(10);

        counter.printValue();

        counter.decrease();
        counter.printValue();

        counter.decrease();
        counter.printValue();
    }
}
