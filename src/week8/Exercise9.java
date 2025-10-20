
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;

public class Exercise9 {

    public static class RegistrationPlate {

        private final String regCode;
        private final String country;

        public RegistrationPlate(String regCode, String country) {
            this.regCode = regCode;
            this.country = country;
        }

        @Override
        public String toString() {
            return country + " " + regCode;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            RegistrationPlate that = (RegistrationPlate) obj;
            if (this.regCode == null) {
                if (that.regCode != null) {
                    return false;
                }
            } else if (!this.regCode.equals(that.regCode)) {
                return false;
            }
            if (this.country == null) {
                return that.country == null;
            } else {
                return this.country.equals(that.country);
            }
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + (this.country == null ? 0 : this.country.hashCode());
            result = 31 * result + (this.regCode == null ? 0 : this.regCode.hashCode());
            return result;
        }
    }

    public static class VehicleRegister {

        private HashMap<RegistrationPlate, String> owners;

        public VehicleRegister() {
            this.owners = new HashMap<>();
        }

        public boolean add(RegistrationPlate plate, String owner) {
            if (this.owners.containsKey(plate)) {
                return false;
            }
            this.owners.put(plate, owner);
            return true;
        }

        public String get(RegistrationPlate plate) {
            return this.owners.get(plate);
        }

        public boolean delete(RegistrationPlate plate) {
            if (!this.owners.containsKey(plate)) {
                return false;
            }
            this.owners.remove(plate);
            return true;
        }

        public void printRegistrationPlates() {
            for (RegistrationPlate plate : this.owners.keySet()) {
                System.out.println(plate);
            }
        }

        public void printOwners() {
            HashSet<String> printed = new HashSet<>();
            for (String owner : this.owners.values()) {
                if (!printed.contains(owner)) {
                    System.out.println(owner);
                    printed.add(owner);
                }
            }
        }
    }

    public static void main(String[] args) {
        RegistrationPlate reg1 = new RegistrationPlate("ABC-123", "FI");
        RegistrationPlate reg2 = new RegistrationPlate("UXE-465", "FI");
        RegistrationPlate reg3 = new RegistrationPlate("B WQ-431", "D");

        ArrayList<RegistrationPlate> finnish = new ArrayList<>();
        finnish.add(reg1);
        finnish.add(reg2);

        RegistrationPlate duplicate = new RegistrationPlate("ABC-123", "FI");
        if (!finnish.contains(duplicate)) {
            finnish.add(duplicate);
        }

        System.out.println("Finnish: " + finnish);

        VehicleRegister register = new VehicleRegister();
        register.add(reg1, "Arto");
        register.add(reg3, "Jürgen");

        System.out.println("owners:");
        System.out.println(register.get(new RegistrationPlate("ABC-123", "FI")));
        System.out.println(register.get(new RegistrationPlate("B WQ-431", "D")));

        System.out.println("\nAll registration plates:");
        register.printRegistrationPlates();

        System.out.println("\nAll owners:");
        register.printOwners();
    }
}
