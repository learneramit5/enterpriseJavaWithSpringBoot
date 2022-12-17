package com.jdbc.dynamicInput;

import java.sql.*;
import java.util.Scanner;

public class InsertApp {
	public void insertValue() throws SQLException{
		
//		resources used in jdbc application
		Connection connection = null;
		Statement statement = null;

		
		String url = "jdbc:mysql://localhost:3306/enterprisejava";
		String username = "root";
		String password = "1234";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter sid");
		int id = sc.nextInt();
		
		System.out.println("Enter the sname");
		String name = sc.next(); 
		
		System.out.println("Enter sage");
		int age = sc.nextInt();
		
		System.out.println("Enter the saddress");
		String address = sc.next();
		
//		name = " ' " +name +" ' ";
//		address = " ' " +address +" ' ";
		
//		Establish the connection 
		connection = DriverManager.getConnection(url, username, password);
		
//		Creation of statement object
		if(connection != null) 
		statement  = connection.createStatement();
		
//		using statement object to execute query
		/* String insertQuery = "insert into student (`sid`, `sname`,`sage`,`saddress`)"
				+ "values("+id +"," +name+"," +age+ "," +address+")"; */
		
		String insertQuery = String.format("insert into student (`sid`, `sname`,`sage`,`saddress`)"
				+ "values('%d','%s','%d','%s')",id,name,age,address);
		
		
		if(statement != null) {
	    int noOfRows = statement.executeUpdate(insertQuery);
	    System.out.println("Entry Added Successfully\n"+insertQuery);
		System.out.println("No of Rows affected: " +noOfRows);
		}
		
//		closing the resources
		if(statement != null)
			statement.close();
		
		if(connection != null)
			connection.close();
		
		if(sc != null)
			sc.close();
		
	}

}
