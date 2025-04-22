package sriMataji.genericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {

	public void executeQueryJDBC(String query, String table_name) throws SQLException {
		//Create an Object for jdbc
		Driver dRef= new Driver();
	    
		//Register the driver
		DriverManager.registerDriver(dRef);
		
		//Connect to Database
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/sms", "root", "TIGER");
		
		//Issue create Statement
		Statement state = con.createStatement();
		
		int result =state.executeUpdate(query);
		
		if(result>=1) {
			System.out.println("Updated"+result);
		}
		
		/*
		 
		ResultSet res = state.executeQuery("select * from"+table_name+";");
		{
			for(int i=0;res.next();i++) {
				System.out.println(i);
			}
		}
		*/
		//Close the DataBase
		
		con.close();
		System.out.println("Connection terminated");
  }	
}
