package App;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminAccess extends BookshopApp{
	Scanner sc = new Scanner(System.in);
	public AdminAccess() throws SQLException {
		System.out.println("Enter USERNAME: ");
		int userid = sc.nextInt();
		System.out.println("Enter PASSWORD: ");
		String password = sc.next();
		if(Adminlog(userid,password)) {
			Menu();
		}else {
			System.out.println("Invalid Username or Password");
		}
	}
	// Dashboard for Admin.
	public void Menu() throws SQLException ,InputMismatchException{
		while(true) {
			System.out.println("Dashboard");
			System.out.println("1 - AddBook\n2 - ViewBooks\n3 - Edit\n4 - Delete");
			System.out.print("0 - Logout\nEnter your Choice: ");
			int n = sc.nextInt();
			if(n==1) {
				System.out.print("Enter ID: ");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter BOOK TITLE: ");
				String bt = sc.nextLine();
				System.out.print("Enter AUTHOR NAME: ");
				String Aname = sc.nextLine();
				System.out.print("Enter QUANTITY: ");
				int quant = sc.nextInt();
				System.out.print("Enter PRICE: ");
				float price = sc.nextFloat();
				int r = add(id,bt,Aname,quant,price);
				System.out.println((r>0)?"Saved Successfully":"Failed");
				System.out.println();
			}
			else if(n==2) {
				display();
				System.out.println();
			}else if(n==3) {
				System.out.println("Enter ID: ");
				int id = sc.nextInt();
				System.out.println("Enter Quantity: ");
				int quant = sc.nextInt();
				
				int r = edit(id,quant);
				System.out.println((r>0)?"Updated Successfully":"Failed");
				System.out.println();
			}else if(n==4) {
				System.out.println("Enter ID: ");
				int id = sc.nextInt();
				
				int r = delete(id);
				System.out.println((r>0)?"Deleted Successfully":"Failed");
				System.out.println();
			}else if(n==0) {
				System.out.println("Logged out Successfully\n");
				user();
			}else {
				System.out.println("Invalid Choice Try Again!!!!!");
				user();
			}
		}
	}
}
