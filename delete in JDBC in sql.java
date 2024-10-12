import java.sql.*;

public class JDBCDemo {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbcdemo";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Velavan@2019";

    public static void main(String[] args) {
        try {
            delete();
        } catch (Exception e) {
            e.printStackTrace(); // Print any exceptions
        }
    }

    public static void delete() throws Exception {
        // Removed redundant variable declarations
        int id = 41;

        // Corrected SQL query
        String query = "DELETE FROM employee WHERE emp_id = " + id;

        Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement st = con.createStatement();
        int rows = st.executeUpdate(query);

        System.out.println("Number of rows affected: " + rows);
        
        // Close resources
        st.close();
        con.close();
    }
}
