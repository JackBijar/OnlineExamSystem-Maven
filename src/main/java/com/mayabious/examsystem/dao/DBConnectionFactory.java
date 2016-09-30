package com.mayabious.examsystem.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;

public class DBConnectionFactory 
{
	static Connection con;
	public static Connection getConnection() throws ClassNotFoundException
	{		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver"); 
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:12345/examination_system", "root", "root"); // LOCAL
			//con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/examination_system", "root", "root"); // SERVER
			
			if(con != null)
				System.out.println("Success");
			else
				System.out.println("Not Success");
		}
		catch (SQLException ex)
		{		    
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}
