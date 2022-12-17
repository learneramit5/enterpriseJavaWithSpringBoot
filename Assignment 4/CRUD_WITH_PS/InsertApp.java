package com.jdbc.preparedStatement;

import java.sql.*;
import java.util.Scanner;

public class InsertApp {
	public void insertValue(){
		
//		resources used in JDBC application
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter sid");
		int id = sc.nextInt();
		
		System.out.println("Enter the sname");
		String name = sc.next(); 
		
		System.out.println("Enter sage");
		int age = sc.nextInt();
		
		System.out.println("Enter the saddress");
		String address = sc.next();

		try {
			connection = JdbcUtil.getConnection();	
			
			String insertQuery = "insert into student(`sid`,`sname`,`sage`,`saddress`) values(?,?,?,?)";
			if(connection != null) {
				pstmt = connection.prepareStatement(insertQuery);
			}
			
			if(pstmt != null) {
				pstmt.setInt(1, id);
				pstmt.setString(2, name);
				pstmt.setInt(3, age);
				pstmt.setString(4, address);
				int rowsAffected = pstmt.executeUpdate();
				System.out.println("No of Rows Affected :: "+rowsAffected);
				
			}
			
		} catch(SQLException se) {
			se.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		 finally {
			try {
				JdbcUtil.closeResource(null, pstmt, connection, sc);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 }


	}

}
