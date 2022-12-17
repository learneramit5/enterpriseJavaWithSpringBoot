package com.jdbc.preparedStatement;

import java.sql.*;

public class SelectAll {
	
	public void selectAll() {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		try {
			connection = JdbcUtil.getConnection();
			
			String selectQuery = "select `sid`,`sname`, `sage`,`saddress` from student";
			pstmt = connection.prepareStatement(selectQuery);
			
			resultSet =  pstmt.executeQuery();
			
			if(resultSet != null) {
				System.out.println("sid\tsname\tsage\tsaddress");
				while(resultSet.next()) {
					System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3)
							+ "\t" + resultSet.getString(4));
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.closeResource(resultSet, pstmt, connection, null);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
