public class EmployeeManagementTest {
    public static void main(String[] args) {
        EmployeeManagement management = new EmployeeManagement();

        Employee emp1 = new Employee(1, "Alice", "123 Elm St");
        Employee emp2 = new Employee(2, "Bob", "456 Oak St");

        management.addEmployee(emp1);
        management.addEmployee(emp2);

        management.displayEmployees();

        management.updateEmployee(1, "789 Pine St");
        management.removeEmployee(2);

        management.displayEmployees();
    }
}
