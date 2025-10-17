
import java.util.HashMap;
import java.util.Scanner;

public class Exercise7 {
    static class Dictionary {
        private HashMap<String, String> translations;

        public Dictionary() {
            this.translations = new java.util.HashMap<>();
        }

        public void add(String word, String translation) {
            this.translations.put(word, translation);
        }

        public String translate(String word) {
            return this.translations.getOrDefault(word, null);
        }

        public int amountOfWords() {
            return this.translations.size();
        }

        public String translationList() {
            StringBuilder list = new StringBuilder();
            for (String word : this.translations.keySet()) {
                list.append(word).append(" = ").append(this.translations.get(word)).append("\n");   
            }
            return list.toString();
        }
    }

    static class TextUserInterface {
        private Scanner scanner;
        private Dictionary dictionary;

        public TextUserInterface(Scanner scanner, Dictionary dictionary) {
            this.scanner = scanner;
            this.dictionary = dictionary;
        }

        public void start() {
            while (true) {
                System.out.print("Command: ");
                String command = scanner.nextLine();

                if (command.equals("end")) {
                    System.out.println("Bye bye!");
                    break;
                } else if (command.equals("add")) {
                    System.out.print("Word: ");
                    String word = scanner.nextLine();
                    System.out.print("Translation: ");
                    String translation = scanner.nextLine();
                    dictionary.add(word, translation);
                } else if (command.equals("translate")) {
                    System.out.print("Word: ");
                    String word = scanner.nextLine();
                    String translation = dictionary.translate(word);
                    if (translation != null) {
                        System.out.println("Translation: " + translation);
                    } else {
                        System.out.println("Word not found.");
                    }
                } else if (command.equals("list")) {
                    System.out.println("Dictionary contents:");
                    System.out.print(dictionary.translationList());
                } else {
                    System.out.println("Unknown command.");
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Dictionary dict = new Dictionary();

        TextUserInterface ui = new TextUserInterface(reader, dict);
        ui.start();
    }
}