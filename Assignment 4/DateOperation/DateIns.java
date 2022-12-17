package com.DateOperation;

import java.sql.*;
import java.text.*;
import java.util.Scanner;

public class DateIns {

	public static void main(String[] args){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		Scanner sc = null;
		
		try {
			con = JdbcUtil.getConnection();
			sc = new Scanner(System.in);
			
			System.out.print("Enter Name: ");
			String name = sc.next();
			
			System.out.print("Enter Age: ");
			int age = sc.nextInt();
			
			System.out.print("Enter DOB in dd-MM-yyyy format: ");
			String dob = sc.next();
			SimpleDateFormat sdfdob = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date udob = sdfdob.parse(dob);
			long ldob = udob.getTime();
			java.sql.Date sqlDob = new java.sql.Date(ldob);
			
			
			System.out.print("Enter DOM in yyyy-MM-dd: ");
			String dom = sc.next();
			//Converting string date to SQL date directly (if string input is in 'yyyy-MM-dd' format)
			Date sqlDom = Date.valueOf(dom);
			
			System.out.print("Enter DOJ in MM-dd-yyyy format: ");
			String doj = sc.next();
			SimpleDateFormat sdfdoj = new SimpleDateFormat("MM-dd-yyyy");
			java.util.Date udoj = sdfdoj.parse(doj);
			long ldoj = udoj.getTime();
			java.sql.Date sqlDoj = new java.sql.Date(ldoj);
			
			String sqlInsert = "insert into userdate (`name`,`age`,`dob`,`dom`,`doj`) values (?,?,?,?,?)";
			if(con != null)
				pstmt = con.prepareStatement(sqlInsert);
			if(pstmt != null) {
				pstmt.setString(1, name);
				pstmt.setInt(2, age);
				pstmt.setDate(3, sqlDob);
				pstmt.setDate(4, sqlDom);
				pstmt.setDate(5, sqlDoj);
				int rowsAffected = pstmt.executeUpdate();
				
				if(rowsAffected > 0)
					System.out.println("Query OK, " +rowsAffected+ " rows affected");
				else
					System.out.println("You have an error! rows not inserted");
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(ParseException pe) {
			pe.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				JdbcUtil.closeResource(null, pstmt, con, sc);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
