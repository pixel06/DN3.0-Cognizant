import java.util.LinkedHashSet;

public class BookCollection {
    private LinkedHashSet<String> books;

    public BookCollection() {
        books = new LinkedHashSet<>();
    }

    public void addBook(String bookTitle) {
        if (books.add(bookTitle)) {
            System.out.println(bookTitle + " added.");
        } else {
            System.out.println(bookTitle + " already exists.");
        }
    }

    public void removeBook(String bookTitle) {
        if (books.remove(bookTitle)) {
            System.out.println(bookTitle + " removed.");
        } else {
            System.out.println(bookTitle + " not found.");
        }
    }

    public void displayBooks() {
        System.out.println("Books in collection:");
        for (String book : books) {
            System.out.println(book);
        }
    }
}
