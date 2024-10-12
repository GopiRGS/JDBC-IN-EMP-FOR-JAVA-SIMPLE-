



import java.sql.*;

public class JDBCDemo {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbcdemo1"; // Make sure this is the correct DB
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Velavan@2019";

    public static void main(String[] args) {
        try {
            batchdemo();
        } catch (Exception e) {
            e.printStackTrace(); // Print any exceptions
        }
    }

    public static void batchdemo() throws Exception{
      String URL = "jdbc:mysql://localhost:3306/jdbcdemo1"; // Make sure this is the correct DB
      String USERNAME = "root";
      String PASSWORD = "Velavan@2019";
      
      String query1 = "update employee set salary = 400000 WHERE emp_id = 1";
      String query2 = "update employee set salary = 400000 WHERE emp_id = 2";
      String query3 = "update employee set salary = 400000 WHERE emp_id = 3";
      
      Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
      
      con.setAutoCommit(false);
      
      Statement st = con.createStatement();
      
      st.addBatch(query1);
      st.addBatch(query2);
      st.addBatch(query3);
    
      int[] res = st.executeBatch();
      
      for(int i : res) {
    	  if(i>0)
    		  continue;
    	  else
    		  con.rollback();
      }
     con.commit(); 
    con.close();
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




