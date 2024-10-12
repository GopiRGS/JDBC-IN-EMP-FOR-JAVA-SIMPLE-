import java.sql.*;

public class JDBCDemo {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbcdemo";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Velavan@2019";

    public static void main(String[] args) {
        try {
            sp();
        } catch (Exception e) {
            e.printStackTrace(); // Print any exceptions
        }
    }


public static void sp() throws Exception{
   String URL = "jdbc:mysql://localhost:3306/jdbcdemo";
   String USERNAME = "root";
   String PASSWORD = "Velavan@2019";
   
   Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
   CallableStatement  cst = con.prepareCall("{call GetEmp()}");
   ResultSet cs = cst.executeQuery();
   
   while(cs.next()) {
	   System.out.println();
	   System.out.println("ID IS : "+cs.getInt(1));
	   System.out.println("Name Is : "+cs.getString(2));
	   System.out.println("salary is : "+cs.getInt(3));
   }
   
   
   con.close();
   }
}



