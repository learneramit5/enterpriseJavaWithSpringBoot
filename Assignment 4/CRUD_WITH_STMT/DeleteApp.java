package com.jdbc.dynamicInput;

import java.sql.*;
import java.util.*;

public class DeleteApp {

	public void deleteById() throws SQLException{
		
		Connection con = null;
		Statement stmt = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter sid to delete");
		int sid = sc.nextInt();
		
		String url ="jdbc:mysql://localhost:3306/enterprisejava";
		String username = "root";
		String password = "1234";
		con = DriverManager.getConnection(url, username, password);
		
		if(con != null)
			stmt = con.createStatement();
		
		String deleteQuery = String.format("delete from student where sid = '%d'", sid);
		
		if(stmt != null) {
			int noOfRows = stmt.executeUpdate(deleteQuery);
			
			if(noOfRows != 0)
				System.out.println("No of rows Deleted : " +noOfRows);
			else
				System.out.println("No such id found!");
		}
		
		if(stmt != null)
			stmt.close();
		
		if(con != null)
			con.close();
		
		if(sc != null)
			sc.close();

	}

}
