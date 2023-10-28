import java.util.ArrayList;
class Book {
    private String title;
    private String author;
    private String isbn;
    private double price;
    public Book(String title, String author, String isbn, double price) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
    }

    // Getter and setter methods for book properties
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Isbn" + isbn + " (" + price + ")";
    }
}

// BookRecord class
class BookRecord {
    private Book book;
    private int quantityInStock;

    public BookRecord(Book book, int quantityInStock) {
        this.book = book;
        this.quantityInStock = quantityInStock;
    }

    // Getter and setter methods for book record properties
    public Book getBook() {
        return book;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
}

class SearchManager {
    ArrayList<BookRecord> bookRecords;
    public SearchManager(ArrayList<BookRecord> bookRecords) {
        this.bookRecords = bookRecords;
    }
    public ArrayList<BookRecord> search(Book b) {
        ArrayList<BookRecord> ret = new ArrayList<BookRecord>();
        for(BookRecord br : bookRecords) {
            if(
                    (b.getTitle() != null && br.getBook().getTitle().toLowerCase().contains(b.getTitle().toLowerCase())) ||
                            (b.getAuthor() != null && br.getBook().getAuthor().toLowerCase().contains(b.getAuthor().toLowerCase())) ||
                            (b.getIsbn() != null && br.getBook().getIsbn().equals(b.getIsbn().toLowerCase())) ) {
                ret.add(br);
            }
        }
        return ret;
    }
}
class Inventory {
    ArrayList<BookRecord> bookRecords;
    public Inventory() {
        bookRecords = new ArrayList<BookRecord>();
    }
    public void add(Book b,int q) {
        bookRecords.add(new BookRecord(b,q));
    }
    public ArrayList<BookRecord> listAllBooks() {
        return bookRecords;
    }
}

class BookStore {
    private Inventory inventory = new Inventory();
    private SearchManager searchManager = new SearchManager(inventory.listAllBooks());
    public Inventory getInventory() {
        return inventory;
    }
    public SearchManager getSearchManager() {
        return searchManager;
    }
}

public class BookStoreApp {
    public static void main(String[] args) {
        BookStore b2s = new BookStore();
        b2s.getInventory().add(new Book("Java Programming", "John Doe", "1234567890", 29.99),10);
        b2s.getInventory().add(new Book("Python Basics", "Jane Smith", "9876543210", 19.99),20);
        b2s.getInventory().add(new Book("Data Science Essentials", "David Johnson", "5678901234", 39.99),25);
        Book sb = new Book("java",null,null,0.0);
        for(BookRecord br : b2s.getSearchManager().search(sb)) {
            System.out.println(br.getBook());
        }
    }
}