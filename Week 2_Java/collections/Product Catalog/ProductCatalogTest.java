public class ProductCatalogTest {
    public static void main(String[] args) {
        ProductCatalog catalog = new ProductCatalog();

        catalog.addProduct("Laptop");
        catalog.addProduct("Smartphone");
        catalog.addProduct("Smartwatch");

        catalog.displayProducts();

        System.out.println("Searching for 'Laptop': " + catalog.searchProduct("Laptop"));
        System.out.println("Searching for 'Tablet': " + catalog.searchProduct("Tablet"));

        catalog.removeProduct("Smartwatch");
        catalog.displayProducts();
    }
}
