package App;

import java.sql.SQLException;
import java.util.Scanner;

public class CustomerAccess extends BookshopApp{
	Scanner sc = new Scanner(System.in);
	
	public CustomerAccess() throws SQLException {
		System.out.println("Enter USERNAME: ");
		int userid = sc.nextInt();
		System.out.println("Enter PASSWORD: ");
		String password = sc.next();
		if(Clientlog(userid,password)) {
			Menu();
		}else {
			System.out.println("Invalid Username or Password");
		}
	}
	public void Menu() throws SQLException {
		System.out.println("1 - View\n0 - Logout");
		int n = sc.nextInt();
		if(n==1) {
			display();
			Menu();
		}
		else if(n==0) {
			System.out.println("Logged out Successfully\n");
			user();
		}else {
			System.out.println("Invalid Choice");
			user();
		}
	}
	
}
