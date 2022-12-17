package com.jdbc.dynamicInput;

import java.util.Scanner;
import java.sql.*;

public class UpdateApp {

	public void updateById() throws SQLException {

		// collecting db query in a variable
		String updateQuery = "";
		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to Update App! PLease enter sid for which you want to update");
		int sid = sc.nextInt();

		System.out.println("Please Enter which field value you want to update");
		System.out.println("1. Press 1 for sname\n" + "2. Press 2 for sage\n" + "3. Press 3 for saddress");
		int choice = sc.nextInt();

		if (choice == 1) {
			System.out.println("Please enter the new name");
			String sname = sc.next();
			updateQuery = String.format("update student set sname = '%s' where sid = '%d'", sname, sid);
		}

		else if (choice == 2) {
			System.out.println("Please enter updated age");
			int sage = sc.nextInt();
			updateQuery = String.format("update student set sage = '%d' where sid = '%d'", sage, sid);
		}

		else if (choice == 3) {
			System.out.println("Please enter new address name");
			String saddress = sc.next();
			updateQuery = String.format("update student set saddress = '%s' where sid = '%d'", saddress, sid);
		} else
			System.out.println("Invalid choice! Please enter a correct one!");

		Connection con = null;
		Statement stmt = null;

		String url = "jdbc:mysql://localhost:3306/enterprisejava";
		String username = "root";
		String password = "1234";

		con = DriverManager.getConnection(url, username, password);

		if (con != null)
			stmt = con.createStatement();

		if (stmt != null) {
			int noOfRows = stmt.executeUpdate(updateQuery);

			if (noOfRows > 0) {
				System.out.println("No of rows updated: " + noOfRows);
				System.out.println("Value Updated Successfully\nQuery executed is ::" + updateQuery);
			}
			else
				System.out.println("No such sid found");
		}

		if (stmt != null)
			stmt.close();

		if (con != null)
			con.close();

		if (sc != null)
			sc.close();

	}

}
