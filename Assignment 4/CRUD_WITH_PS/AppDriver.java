package com.jdbc.preparedStatement;
import java.util.Scanner;

public class AppDriver {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome! to CRUD operation App (using pstmt)\n" + "Enter choice\n" + "1. Insert\n" + "2. Select all\n"
				+ "3. Select By Id\n" + "4. Delete\n" + "5. Update\n" + "6. Exit");
		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			InsertApp ia = new InsertApp();
			ia.insertValue();
			break;
		case 2:
			SelectAll sa = new SelectAll();
			sa.selectAll();
			break;
		case 3:
			SelectById sid = new SelectById();
			sid.selectById();
			break;
		case 4:
			DeleteApp da = new DeleteApp();
			da.deleteApp();
			break;
		case 5:
			UpdateApp ua = new UpdateApp();
			ua.updateById();
			break;
		case 6:
			System.exit(0);

		default:
			System.out.println("Wrong Choice");
			break;
		}
		if(sc != null) {
			sc.close();
		}

	}

}
