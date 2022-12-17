package com.jdbc.dynamicInput;

import java.util.Scanner;
import java.sql.*;

public class SelectBySid {

	public void selectById() throws SQLException{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to select by sid App\nPlease enter sid");
		int sid = sc.nextInt();
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String url = "jdbc:mysql://localhost:3306/enterprisejava";
		String username = "root";
		String password ="1234";
		con = DriverManager.getConnection(url, username, password);
		
		if(con != null)
			stmt = con.createStatement();
		
		String executeQuery = String.format("select sid,sname,sage,saddress from student where sid = '%d' ", sid);
		
		if(stmt != null)
			rs = stmt.executeQuery(executeQuery);
		
		
		if(rs != null) {
			
			if(rs.next()) {
				System.out.println("sid\tsname\tsage\tsaddress");
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				String address = rs.getString(4);
				System.out.println(id+"\t"+name+"\t"+age+"\t"+address);
			}
			else
				System.out.println("No such sid found!");
		}
		
		//closing the resources
		if(rs != null)
			rs.close();
		
		if(stmt != null)
			stmt.close();
		
		if(con != null)
			con.close();
		
		if(sc != null)
			sc.close();
	}

}
