package Assignment_4;

import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private final String title;
    private final int ISBN;
    private final int barcode;

    public Book(String title, int ISBN, int barcode) {
        this.title = title;
        this.ISBN = ISBN;
        this.barcode = barcode;
    }

    public static void inputbook(ArrayList<Book> books){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter title of book: ");
        String title = s.nextLine();
        System.out.println("Enter ISBN code of book: ");
        int ISBN = s.nextInt();
        System.out.println("Enter barcode of book: ");
        int barcode = s.nextInt();
        books.add(new Book(title, ISBN, barcode));
    }

    @Override
    public String toString() {
        return "Book Title = " + this.getTitle() + ", ISBN = " + this.getISBN() + ", Barcode = " + this.getBarcode();
    }


    public String getTitle() {
        return this.title;
    }

    public int getISBN() {
        return this.ISBN;
    }

    public int getBarcode() {
        return this.barcode;
    }


}

class Library {
    private final int racks;
    private final int tbooks;
    ArrayList<Book> books = new ArrayList<Book>();

    public Library(int racks, int tbooks, ArrayList<Book> books) {
        this.racks = racks;
        this.tbooks = tbooks;
        this.books = books;
    }

    public void getAllBooks() {
        for(Book b: this.getBooks()){
            System.out.println(b.toString());
        }
    }


    public int getRacks() {
        return this.racks;
    }


    public int getTbooks() {
        return this.tbooks;
    }


    public ArrayList<Book> getBooks() {
        return this.books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }


}

public class AP_A4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter no. of racks present in the library: ");
        int racks = s.nextInt();
        System.out.println("Enter total no. of books in the library: ");
        int tbooks = s.nextInt();
        ArrayList<Book> books = new ArrayList<Book>();

        Library l = new Library(racks, tbooks, books);

        for(int i=0;i<tbooks;i++){
            Book.inputbook(books);
        }
        System.out.println("=================== Unsorted Books: ====================");
        System.out.println("--------------------------------------------------------");
        l.getAllBooks();

    }
}