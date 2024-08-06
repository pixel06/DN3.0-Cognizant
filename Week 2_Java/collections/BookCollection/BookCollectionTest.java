public class BookCollectionTest {
    public static void main(String[] args) {
        BookCollection collection = new BookCollection();

        collection.addBook("Moby Dick");
        collection.addBook("To Kill a Mockingbird");
        collection.addBook("1984");

        collection.displayBooks();

        collection.removeBook("To Kill a Mockingbird");
        collection.displayBooks();
    }
}
