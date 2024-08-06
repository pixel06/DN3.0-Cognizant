public class InventoryManagementTest {
    public static void main(String[] args) {
        InventoryManagement management = new InventoryManagement();

        Product p1 = new Product(1, "Laptop", 10);
        Product p2 = new Product(2, "Smartphone", 20);

        management.addProduct(p1);
        management.addProduct(p2);

        management.displayProducts();

        management.updateProductQuantity(1, 15);
        management.removeProduct(2);

        management.displayProducts();
    }
}
