package com.jdbc.preparedStatement;

import java.util.Scanner;
import java.sql.*;

public class UpdateApp {

	public void updateById() {

		Connection con = null;
		PreparedStatement pstmt = null;
		String updateQuery = "";
		Scanner sc = new Scanner(System.in);

		try {
			con = JdbcUtil.getConnection();

			if (con != null) {
				System.out.println("Please enter sid for which you want to update");
				int sid = sc.nextInt();

				System.out.println("Please Enter which field value you want to update");
				System.out.println("1.Name\n" + "2.Age\n" + "3.Address");
				int choice = sc.nextInt();

				if (choice == 1) {
					System.out.println("Please enter the new name");
					String sname = sc.next();
					updateQuery = "update student set sname = ? where sid = ?";
					pstmt = con.prepareStatement(updateQuery);
					pstmt.setString(1, sname);
					pstmt.setInt(2, sid);
				}

				else if (choice == 2) {
					System.out.println("Please enter updated age");
					int sage = sc.nextInt();
					updateQuery = "update student set sage = ? where sid = ?";
					pstmt = con.prepareStatement(updateQuery);
					pstmt.setInt(1, sage);
					pstmt.setInt(2, sid);
				}

				else if (choice == 3) {
					System.out.println("Please enter new address name");
					String saddress = sc.next();
					updateQuery = "update student set saddress = ? where sid = ?";
					pstmt = con.prepareStatement(updateQuery);
					pstmt.setString(1, saddress);
					pstmt.setInt(2, sid);
					
				} else
					System.out.println("Invalid choice! Please enter a correct one!");
			}

			if (pstmt != null) {
				int noOfRows = pstmt.executeUpdate();

				if (noOfRows > 0)
					System.out.println("No of rows updated: " + noOfRows);
				else
					System.out.println("No such sid found");
			}
		}catch (SQLException se) {
			se.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				JdbcUtil.closeResource(null, pstmt, con, sc);
			}catch(SQLException se)
			{
				se.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
