package com.jdbc.dynamicInput;

import java.sql.SQLException;
import java.util.*;

public class AppDriver {

	public static void main(String[] args) throws SQLException{
		
		Scanner sc = new Scanner(System.in);

			System.out.println("Welcome! to CRUD operation App\n" + "Enter choice\n" + "1. Insert\n" + "2. Select all\n"
					+ "3. Select By Id\n" + "4. Update\n" + "5. Delete\n" + "6. Exit");
			
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				InsertApp ia = new InsertApp();
				ia.insertValue();
				break;
			case 2:
				SelectApp sa = new SelectApp();
				sa.selectAll();
				break;
			case 3:
				SelectBySid sid = new SelectBySid();
				sid.selectById();
				break;
			case 4:
				UpdateApp ua = new UpdateApp();
				ua.updateById();
				break;
			case 5:
				DeleteApp da = new DeleteApp();
				da.deleteById();
				break;
			case 6:
				System.exit(0);

			default:
				System.out.println("Please enter a valid choice");
				break;
			}

		if (sc != null)
			sc.close();
	}

}
