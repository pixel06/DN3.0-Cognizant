import java.util.HashSet;

public class ProductCatalog {
    private HashSet<String> products;

    public ProductCatalog() {
        products = new HashSet<>();
    }

    public void addProduct(String productName) {
        if (products.add(productName)) {
            System.out.println(productName + " added.");
        } else {
            System.out.println(productName + " already exists.");
        }
    }

    public void removeProduct(String productName) {
        if (products.remove(productName)) {
            System.out.println(productName + " removed.");
        } else {
            System.out.println(productName + " not found.");
        }
    }

    public boolean searchProduct(String productName) {
        return products.contains(productName);
    }

    public void displayProducts() {
        System.out.println("Products in catalog:");
        for (String product : products) {
            System.out.println(product);
        }
    }
}
