
public class Exercise10 {

    public interface NationalService {

        int getDaysLeft();

        void work();
    }

    public static class CivilService implements NationalService {

        private int daysLeft;

        public CivilService() {
            this.daysLeft = 362;
        }

        @Override
        public int getDaysLeft() {
            return this.daysLeft;
        }

        @Override
        public void work() {
            if (this.daysLeft > 0) {
                this.daysLeft -= 1;
            }
        }
    }

    public static class MilitaryService implements NationalService {

        private int daysLeft;

        public MilitaryService(int daysLeft) {
            this.daysLeft = daysLeft;
        }

        @Override
        public int getDaysLeft() {
            return this.daysLeft;
        }

        @Override
        public void work() {
            if (this.daysLeft > 0) {
                this.daysLeft -= 1;
            }
        }
    }

    public static void main(String[] args) {
        CivilService civil = new CivilService();
        MilitaryService military = new MilitaryService(5);

        System.out.println("Civil days left: " + civil.getDaysLeft());
        civil.work();
        System.out.println("Civil days left after working once: " + civil.getDaysLeft());

        System.out.println("Military days left: " + military.getDaysLeft());
        for (int i = 0; i < 7; i++) {
            military.work();
            System.out.println("Military days left after work: " + military.getDaysLeft());
        }
    }
}
