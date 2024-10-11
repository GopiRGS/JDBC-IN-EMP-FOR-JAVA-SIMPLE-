import java.sql.*;

public class JDBCDemo {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbcdemo";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Velavan@2019";

    public static void main(String[] args) {
        try {
            readRecords();

        } catch (Exception e) {
            e.printStackTrace(); // Print any exceptions
        }
    }

    public static void readRecords() {
        String query = "SELECT * FROM employee";

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            // Process the ResultSet
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt(1));
                System.out.println("Name: " + rs.getString(2));
                System.out.println("Salary: " + rs.getInt(3));
                System.out.println(); // Adding an empty line for better readability
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print any SQL exceptions
        }
    }

    public static void insertVar() {
    	int id =51;
    	String name = "dharun";
    	int salary = 410998;
    	
    	//insert into employee values (5,'varun',30000);
        String query = "INSERT INTO employee VALUES (" + id +  ",'" + name + "'," + salary + ");";

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement st = con.createStatement()) {

            int rows = st.executeUpdate(query);
            System.out.println("Number of rows affected: " + rows);
        } catch (SQLException e) {
            e.printStackTrace(); // Print any SQL exceptions
        }
    }
    public static void insertRecords() {
        String query = "INSERT INTO employee VALUES (41, 'SOUND', 1500)";

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement st = con.createStatement()) {

            int rows = st.executeUpdate(query);
            System.out.println("Number of rows affected: " + rows);
        } catch (SQLException e) {
            e.printStackTrace(); // Print any SQL exceptions
        }
    }
}
