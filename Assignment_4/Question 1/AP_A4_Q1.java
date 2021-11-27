import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Book {
    private final String title;
    private final int ISBN;
    private final int barcode;
    private int rack;
    private int slot;

    public Book(String title, int ISBN, int barcode) {
        this.title = title;
        this.ISBN = ISBN;
        this.barcode = barcode;
        this.rack = 0;
        this.slot = 0;
    }

    public static void inputbook(ArrayList<Book> books, int n) {
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.println("Enter title of book: ");
            String title = s.nextLine();
            System.out.println("Enter ISBN code of book: ");
            int ISBN = s.nextInt();
            System.out.println("Enter barcode of book: ");
            int barcode = s.nextInt();
            s.nextLine();
            books.add(new Book(title, ISBN, barcode));
        }
        s.close();

    }

    @Override
    public String toString() {
        return "Book Title = " + this.getTitle() + " , ISBN = " + this.getISBN() + " , Barcode = " + this.getBarcode() + " , Rack = " + this.getRack() + " , Slot = " + this.getSlot();
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

    public int getRack() {
        return this.rack;
    }

    public void setRack(int rack) {
        this.rack = rack;
    }

    public int getSlot() {
        return this.slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

}

class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        if (o1.getTitle().compareTo(o2.getTitle()) > 0) {
            return 1;
        } else if (o1.getTitle().compareTo(o2.getTitle()) < 0) {
            return -1;
        } else {
            if (o1.getISBN() > o2.getISBN()) {
                return 1;
            } else if (o1.getISBN() < o2.getISBN()) {
                return -1;
            } else {
                if (o1.getBarcode() > o2.getBarcode()) {
                    return 1;
                } else if (o1.getBarcode() < o2.getBarcode()) {
                    return -1;
                }
                return 0;
            }

        }
    }
}

class Library {
    private final int racks;
    private final int tbooks;
    private final int slots;
    ArrayList<Book> books = new ArrayList<>();;

    public Library(int racks, int tbooks, ArrayList<Book> books2) {
        this.racks = racks;
        this.tbooks = tbooks;
        this.books = books2;
        this.slots = (int) (tbooks / racks);
    }

    public void getAllBooks() {
        for (Object b : this.getBooks()) {
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

    public int getSlots() {
        return this.slots;
    }

    public static void compareBooks(List<Book> books) {
        Collections.sort(books, new BookComparator());
    }

    public void setsSlots(ArrayList<Book> books) {
        int it = 0;//interator of books
        int a = 0;//rack 
        for(int i = 0; i<this.getRacks();i++) {
            a++;
            int b = 0;
            for(int j = 0; j<this.getSlots(); j++){
                b++;
                books.get(it).setRack(a);
                books.get(it).setSlot(b);
                it++;
            }
        }
    }

}

public class AP_A4_Q1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter no. of racks present in the library: ");
        int racks = s.nextInt();
        System.out.println("Enter total no. of books in the library: ");
        int tbooks = s.nextInt();
        ArrayList<Book> books = new ArrayList<>();

        Library l = new Library(racks, tbooks, books);
        Book.inputbook(books, tbooks);

        System.out.println("=================== Unsorted Books: ====================");
        System.out.println("--------------------------------------------------------");
        System.out.println();
        l.getAllBooks();

        Library.compareBooks(books);
        l.setsSlots(books);

        System.out.println();
        System.out.println("==================== Sorted Books: =====================");
        System.out.println("--------------------------------------------------------");
        System.out.println();
        l.getAllBooks();
        s.close();
    }
}
