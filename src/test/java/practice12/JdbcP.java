package practice12;

import java.sql.SQLException;

import sriMataji.genericUtilities.DatabaseUtility;

public class JdbcP {

	public static void main(String[] args) throws Throwable  {
		
		DatabaseUtility refD= new DatabaseUtility();
		refD.executeQueryJDBC("insert into my_table values(7,'Hari',30);", "my_table");

	}

}
