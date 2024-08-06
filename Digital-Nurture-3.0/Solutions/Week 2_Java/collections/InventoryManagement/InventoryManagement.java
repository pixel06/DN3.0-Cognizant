import java.util.HashMap;
import java.util.Map;

public class InventoryManagement {
    private HashMap<Integer, Product> inventory;

    public InventoryManagement() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getId(), product);
        System.out.println("Product added: " + product);
    }

    public void removeProduct(int productId) {
        Product removedProduct = inventory.remove(productId);
        if (removedProduct != null) {
            System.out.println("Product removed: " + removedProduct);
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

    public void updateProductQuantity(int productId, int newQuantity) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.setQuantity(newQuantity);
            System.out.println("Updated quantity for product ID " + productId + ": " + newQuantity);
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

    public void displayProducts() {
        System.out.println("Inventory:");
        for (Map.Entry<Integer, Product> entry : inventory.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
