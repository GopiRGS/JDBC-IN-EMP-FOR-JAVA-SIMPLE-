



import java.sql.*;

public class JDBCDemo {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbcdemo1"; // Make sure this is the correct DB
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Velavan@2019";

    public static void main(String[] args) {
        try {
            commitdemo();
        } catch (Exception e) {
            e.printStackTrace(); // Print any exceptions
        }
    }

    public static void commitdemo() throws Exception{
      String URL = "jdbc:mysql://localhost:3306/jdbcdemo1"; // Make sure this is the correct DB
      String USERNAME = "root";
      String PASSWORD = "Velavan@2019";
      
      String query1 = "update employee set salary = 500000 WHERE emp_id = 1";
      String query2 = "update employee set salary = 600000 WHERE emp_id = 2";
      
      Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
      
      con.setAutoCommit(false);
      
      Statement st = con.createStatement();
     int rows1=  st.executeUpdate(query1);
     System.out.println("Number of rows affected : "+rows1);
     
     
     int rows2 = st.executeUpdate(query2);
     System.out.println("NUMber of rows affected : "+rows2);
      
     if(rows1>0 && rows2>0) {
    	 con.commit();
    
    con.close();
     }
    	
    }
   
}



//SQL CODE 



create database jdbcdemo1;

use jdbcdemo1;

create table employee(
emp_id int primary key,
ename varchar(30),
salary int
);

insert into employee values (1,"Ram",100000);

select * from employee;

insert into employee values(2,"Gopi",20000);

insert into employee values(3,"Gokul",400000);







