import java.sql.*;

public class JDBCDemo {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbcdemo";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Velavan@2019";

    public static void main(String[] args) {
        try {
            update();
        } catch (Exception e) {
            e.printStackTrace(); // Print any exceptions
        }
    }



//update the query

public static void update() throws Exception {
    // Removed redundant variable declarations

    // Corrected SQL query
    String query = "update employee set salary = 19000 where emp_id = 1 ";

    Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    Statement st = con.createStatement();
    int rows = st.executeUpdate(query);

    System.out.println("Number of rows affected: " + rows);
    

    con.close();
}
}

