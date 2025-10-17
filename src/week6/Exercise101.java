package week6;

import java.util.ArrayList;

public class Exercise101 {

    public class StringUtils {
        public static boolean included(String word, String searched) {
            String wordLower = word.toLowerCase();
            String searchedLower = searched.toLowerCase();

            return wordLower.contains(searchedLower);
        }
    }

    static class Library {
        private ArrayList<Book> books;

        public Library() {
            this.books = new ArrayList<>();
        }

        public void addBook(Book newBook) {
            this.books.add(newBook);
        }

        public void printBooks() {
            for (Book book : books) {
                System.out.println(book);
            }
        }

        public ArrayList<Book> searchByTitle(String title) {
            ArrayList<Book> found = new ArrayList<Book>();
            for (Book book : books) {
                if (StringUtils.included(book.title(), title)) {
                    found.add(book);
                }
            }
            return found;
        }

        public ArrayList<Book> searchByPublisher(String publisher) {
            ArrayList<Book> found = new ArrayList<Book>();
            for (Book book : books) {
                if (book.publisher().contains(publisher)) {
                    found.add(book);
                }
            }
            return found;
        }

        public ArrayList<Book> searchByYear(int year) {
            ArrayList<Book> found = new ArrayList<Book>();
            for (Book book : books) {
                if (book.year() == year) {
                    found.add(book);
                }
            }
            return found;
        }
    }

    static class Book {
        private String title;
        private String publisher;
        private int year;

        public Book(String title, String publisher, int year) {
            this.title = title;
            this.publisher = publisher;
            this.year = year;
        }

        public String title() {
            return this.title;
        }

        public String publisher() {
            return this.publisher;
        }

        public int year() {
            return this.year;
        }

        @Override
        public String toString() {
            return this.title + ", " + this.publisher + ", " + this.year;
        }
    }

    public static void main(String[] args) {
        Library Library = new Library();

        Library.addBook(new Book("Cheese Problems Solved", "Woodhead Publishing", 2007));
        Library.addBook(new Book("The Stinky Cheese Man and Other Fairly Stupid Tales", "Penguin Group", 1992));
        Library.addBook(new Book("NHL Hockey", "Stanley Kupp", 1952));
        Library.addBook(new Book("Battle Axes", "Tom A. Hawk", 1851));

        for (Book book : Library.searchByTitle("CHEESE")) {
            System.out.println(book);
        }

        System.out.println("---");
        for (Book book : Library.searchByPublisher("PENGUIN  ")) {
            System.out.println(book);
        }
        System.out.println("---");
        for (Book book : Library.searchByYear(1851)) {
            System.out.println(book);
        }
    }
}
