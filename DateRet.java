package assignment4;
import java.sql.*;
import java.text.SimpleDateFormat;

public class DateRet {
	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = JdbcUtil.getConnection();
			String selectQuery = "select name,age,dob,dom,doj from userdate";
			if(con != null)
				pstmt = con.prepareStatement(selectQuery);
			if(pstmt != null)
				rs = pstmt.executeQuery();
			
			SimpleDateFormat sdf = new SimpleDateFormat();
			if(rs != null) {
				System.out.println("name\tage\tdob\t\tdom\t\tdoj");
				while(rs.next()) {
					String name = rs.getString(1);
				    int age = rs.getInt(2);
				    
					Date dob = rs.getDate(3);
					String sdob = sdf.format(dob);
					
					Date dom = rs.getDate(4);
					String sdom = sdf.format(dom);
					
					Date doj = rs.getDate(5);
					String sdoj = sdf.format(doj);
					
					System.out.println(name+"\t"+age+"\t"+sdob+"\t"+sdom+"\t"+sdoj);
				}
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
				JdbcUtil.closeResource(rs, pstmt, con, null);
			}catch(SQLException se) {
				se.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}
