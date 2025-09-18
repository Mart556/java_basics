class BoundedCounter {
    private int value;
    private int upperLimit;

    public BoundedCounter(int upperLimit, int initialValue) {
        this.upperLimit = upperLimit;
        this.value = initialValue;
    }

    public boolean next() {
        this.value++;

        if  (this.value > this.upperLimit) {
            this.value = 0;
            return true;
        }

        return false;
    }

    public String toString() {
        return String.format("%02d", this.value);
    }
}

 class Clock {
    private BoundedCounter hours;
    private BoundedCounter minutes;
    private BoundedCounter seconds;

    public Clock(int hoursAtBeginning, int minutesAtBeginning, int secondsAtBeginning) {
        this.hours = new BoundedCounter(24 ,  hoursAtBeginning);
        this.minutes = new BoundedCounter(60,  minutesAtBeginning);
        this.seconds = new BoundedCounter(60,   secondsAtBeginning);

        System.out.println("Clock constructor " + this.hours);
    }

    public void tick(){
        if (this.seconds.next()) {
            if (this.minutes.next()) {
                this.hours.next();
            }
        }

    }

    public String toString() {
        return this.hours.toString() + ":" + this.minutes.toString() + ":" + this.seconds.toString();
    }
}

public class Exercise89 {
    public static void main(String[] args) throws InterruptedException {
        Clock clock = new Clock(23, 22, 55);

        while (true) {
          clock.tick();
          Thread.sleep(1000);

          System.out.println(clock.toString());
        }
    }
}
