import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbcdemo";
        String userName = "root";
        String password = "Velavan@2019";
        String query = "SELECT * FROM employee";

        // Using try-with-resources to automatically close resources
        try (Connection con = DriverManager.getConnection(url, userName, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            // Process the ResultSet
            while (rs.next()) {
                System.out.println("ID is: " + rs.getInt(1));
                System.out.println("Name is: " + rs.getString(2));
                System.out.println("Salary is: " + rs.getInt(3));
                System.out.println(); // Adding an empty line for better readability
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Print any SQL exceptions
        }
    }
}
