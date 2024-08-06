package EmployeeDataRetrieval;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class EmployeeDataRetrieval {

    public static void getEmployees() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            
            connection = JDBCConnection.getConnection();

            if (connection != null) {
               
                statement = connection.createStatement();

                
                String query = "SELECT * FROM employees";
                resultSet = statement.executeQuery(query);

                
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String position = resultSet.getString("position");
                    double salary = resultSet.getDouble("salary");

                    System.out.println("ID: " + id + ", Name: " + name + ", Position: " + position + ", Salary: " + salary);
                }
            } else {
                System.out.println("Failed to establish connection");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        getEmployees();
    }
}
