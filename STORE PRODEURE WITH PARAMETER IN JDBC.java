



import java.sql.*;

public class JDBCDemo {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbcdemo1"; // Make sure this is the correct DB
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Velavan@2019";

    public static void main(String[] args) {
        try {
            sp2();
        } catch (Exception e) {
            e.printStackTrace(); // Print any exceptions
        }
    }

    public static void sp2() throws Exception {
        // Use the class-level constants for consistency
        Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        CallableStatement cst = con.prepareCall("{call GetEmp(?)}");
        int id = 1;

        try {
            cst.setInt(1, id);
            ResultSet cs = cst.executeQuery();

            while (cs.next()) {
                System.out.println();
                System.out.println("ID IS : " + cs.getInt(1));
                System.out.println("Name Is : " + cs.getString(2));
                System.out.println("Salary Is : " + cs.getInt(3));
            }
            cs.close(); // Close ResultSet
        }catch(Exception e) {
        	 e.printStackTrace(); // Print any exceptions
        	
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


delimiter $$
create procedure GetEmp(In id int)
begin
	select * from employee;
	select * from employee where emp_id = id;
end$$
delimiter ;







