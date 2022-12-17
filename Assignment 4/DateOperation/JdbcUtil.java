package com.DateOperation;

import java.sql.*;
import java.util.Scanner;

public class JdbcUtil {

	public static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/enterprisejava";
		String username = "root";
		String password = "1234";

		return DriverManager.getConnection(url, username, password);
	}

	public static void closeResource(ResultSet resultSet, Statement statement, Connection connection, Scanner sc)
			throws SQLException {

		if (resultSet != null)
			resultSet.close();

		if (statement != null)
			statement.close();

		if (connection != null)
			connection.close();

		if (sc != null)
			sc.close();

	}

}
