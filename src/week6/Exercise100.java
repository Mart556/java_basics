package week6;

public class Exercise100 {

    static class NightSky {
        private double density;
        private int width;
        private int height;
        int starsPrinted;

        NightSky(double density, int width, int height) {
            this.density = density;
            this.width = width;
            this.height = height;
        }

        public void printLine() {
            for (int i = 0; i < this.width; i++) {
                if (Math.random() < this.density) {
                    System.out.print("*");
                    starsPrinted++;
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        public void print() {
            for (int i = 0; i < Math.random() * this.height; i++) {
                this.printLine();
            }
        }

        public int starsInLastPrint() {
            return starsPrinted;
        }

    }

    public static void main(String[] args) {
        NightSky nightSky = new NightSky(0.1, 40, 10);
        nightSky.print();
        System.out.println("Number of stars: " + nightSky.starsInLastPrint());
        System.out.println("");
    }
}
