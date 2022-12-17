package com.jdbc.preparedStatement;

import java.sql.*;
import java.util.*;

public class DeleteApp {

	public void deleteApp() {

		Connection con = null;
		PreparedStatement pstmt = null;

		Scanner sc = new Scanner(System.in);
		System.out.print("Please sid you want to delete: ");
		int sid = sc.nextInt();

		try {
			con = JdbcUtil.getConnection();

			String deleteQuery = "delete from student where sid = ? ";
			if (con != null) {
				pstmt = con.prepareStatement(deleteQuery);
			}

			if (pstmt != null) {
				pstmt.setInt(1, sid);
				int rowsAffected = pstmt.executeUpdate();
				
				if (rowsAffected != 0) {
					System.out.println("row deleted successfully\n No of Rows Affected :: " + rowsAffected);
				}
				else {
					System.out.println("NO Matching Item!\nNo of Rows Affected :: "+rowsAffected);
				}
			}

		} catch (SQLException se) {
			se.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				JdbcUtil.closeResource(null, pstmt, con, sc);
			} catch (SQLException se) {
				se.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
