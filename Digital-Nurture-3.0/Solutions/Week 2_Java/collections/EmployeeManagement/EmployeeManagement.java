import java.util.ArrayList;

public class EmployeeManagement {
    private ArrayList<Employee> employees;

    public EmployeeManagement() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added: " + employee);
    }

    public void removeEmployee(int employeeId) {
        employees.removeIf(emp -> emp.getId() == employeeId);
        System.out.println("Employee removed with ID: " + employeeId);
    }

    public void updateEmployee(int employeeId, String newAddress) {
        for (Employee emp : employees) {
            if (emp.getId() == employeeId) {
                emp.setAddress(newAddress);
                System.out.println("Updated address for ID " + employeeId);
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public void displayEmployees() {
        System.out.println("Employees:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}
