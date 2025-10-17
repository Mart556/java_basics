
import java.util.ArrayList;

public class Exercise4 {
    static class Suitcase {
        int totalWeight = 0;
        int maxWeight;
        ArrayList<Thing> things = new ArrayList<>();

        Suitcase(int maxWeight) {
            this.maxWeight = maxWeight;
        }

        public void addThing(Thing thing) {
            if (totalWeight + thing.getWeight() <= maxWeight) {
                things.add(thing);
                totalWeight += thing.getWeight();
            } else {
                System.out.println("Cannot add " + thing.getName() + ": exceeds maximum weight limit.");
            }
        }

        public String toString() {
            if (things.size() == 0) {
                return "no things (0 kg)";
            } else if (things.size() == 1) {
                return "1 thing (" + totalWeight + " kg)";
            } else {
                return things.size() + " things (" + totalWeight + " kg)";
            }
        }

        public void printThings() {
            for (Thing thing : things) {
                System.out.println(thing.getName() + " (" + thing.getWeight() + " kg)");
            }
        }

        public void heaviestThing() {
            if (things.isEmpty()) {
                System.out.println("No things in the suitcase.");
                return;
            }

            Thing heaviest = things.get(0);
            for (Thing thing : things) {
                if (thing.getWeight() > heaviest.getWeight()) {
                    heaviest = thing;
                }
            }
            System.out.println("Heaviest thing: " + heaviest.getName() + " (" + heaviest.getWeight() + " kg)");
        }
    }

    static class Container {
        int maxWeight;
        ArrayList<Suitcase> suitcases = new ArrayList<>();

        Container(int maxWeight) {
            this.maxWeight = maxWeight;
        }

        public void addSuitcase(Suitcase suitcase) {
            int currentWeight = 0;
            for (Suitcase sc : suitcases) {
                currentWeight += sc.totalWeight;
            }

            if (currentWeight + suitcase.totalWeight <= maxWeight) {
                suitcases.add(suitcase);
            } else {
                System.out.println("Cannot add suitcase: exceeds container weight limit.");
            }
        }

        public String toString() {
            int currentWeight = 0;
            for (Suitcase sc : suitcases) {
                currentWeight += sc.totalWeight;
            }

            if (suitcases.size() == 0) {
                return "no suitcases (0 kg)";
            } else if (suitcases.size() == 1) {
                return "1 suitcase (" + currentWeight + " kg)";
            } else {
                return suitcases.size() + " suitcases (" + currentWeight + " kg)";
            }
        }

        public void printThings() {
            for (Suitcase suitcase : suitcases) {
                suitcase.printThings();
            }
        }
    }

    static class Thing {
        int weight;
        String name;

        Thing(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        Container container = new Container(1000);
        addSuitcasesFullOfBricks(container);
        System.out.println(container);
    }

    public static void addSuitcasesFullOfBricks(Container container) {
        for (int i = 0; i < 100; i++) {
            Suitcase suitcase = new Suitcase(10);
            suitcase.addThing(new Thing("Brick", 9));
            container.addSuitcase(suitcase);
        }
    }
}
