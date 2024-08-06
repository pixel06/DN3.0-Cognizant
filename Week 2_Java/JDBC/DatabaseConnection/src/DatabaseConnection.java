import java.sql.*;

class DatabaseConnection
{
    public static void main(String[] args) {
        
        try {
            Class.forName("com.mysql.jc.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db","root","Sohith@sql2262");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from employees");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getDouble(4));
            }
            con.close();
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
}