package com.jdbc.preparedStatement;

import java.sql.*;
import java.util.Scanner;

public class SelectById {
	
	public void selectById() {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the sid : ");
		int sid = sc.nextInt();
		
		try {
			connection = JdbcUtil.getConnection();
			
			String selectQuery = "select `sid`,`sname`, `sage`,`saddress` from student where sid = ?";
			pstmt = connection.prepareStatement(selectQuery);
			
			if(pstmt != null) {
				pstmt.setInt(1, sid);
				resultSet =  pstmt.executeQuery();
			}
			
			if(resultSet != null) {
				
				if(resultSet.next()) {
					System.out.println("sid\tsname\tsage\tsaddress");
					System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3)
							+ "\t" + resultSet.getString(4));
				}
				else
					System.out.println("No such record found!");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.closeResource(resultSet, pstmt, connection, sc);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
