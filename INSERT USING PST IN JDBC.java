import java.sql.*;

public class JDBCDemo {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbcdemo";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Velavan@2019";

    public static void main(String[] args) {
        try {
            insertusingpst();

        } catch (Exception e) {
            e.printStackTrace(); // Print any exceptions
        }
    }

    
    public static void insertusingpst() throws Exception {
    	
    	String URL = "jdbc:mysql://localhost:3306/jdbcdemo";
    	String USERNAME = "root";
    	String PASSWORD = "Velavan@2019";
    	
    	
    	int id =751;
    	String name = "revathi";
    	int salary = 4177998;
    	
    	//insert into employee values (5,'varun',30000);
        String query = "INSERT INTO employee VALUES (?,?,?);";
       
        Connection con  = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        
        	PreparedStatement pst = con.prepareStatement(query); 
        	pst.setInt(1,id);
        	pst.setString(2,name);
        	pst.setInt(3,salary);
        	int rows = pst.executeUpdate();
        	System.out.println("Number of rows affected : "+rows);
        	
        	con.close();
        	
       
    }
}
