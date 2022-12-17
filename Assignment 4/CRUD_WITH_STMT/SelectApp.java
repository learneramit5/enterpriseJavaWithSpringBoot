package com.jdbc.dynamicInput;

import java.sql.*;

public class SelectApp {
	public void selectAll() throws SQLException {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://localhost:3306/enterprisejava";
		String username = "root";
		String password = "1234";

		con = DriverManager.getConnection(url, username, password);

		if (con != null)
			stmt = con.createStatement();

		String selectQuery = "select sid, sname, sage, saddress from student";
		rs = stmt.executeQuery(selectQuery);

		System.out.println("sid\tsname\tsage\tsaddress");
		while (rs.next()) {
			int sid = rs.getInt(1);
			String sname = rs.getString(2);
			int sage = rs.getInt(3);
			String saddress = rs.getString(4);

			System.out.println(sid + "\t" + sname + "\t" + sage + "\t" + saddress);

		}

		if (rs != null)
			rs.close();

		if (stmt != null)
			stmt.close();

		if (con != null)
			con.close();
	}

}
