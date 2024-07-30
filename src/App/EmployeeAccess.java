package App;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeAccess extends BookshopApp{
	int userid;int n=0;
	public EmployeeAccess() throws SQLException {
		System.out.println("Enter USERNAME: ");
		userid = sc.nextInt();
		System.out.println("Enter PASSWORD: ");
		String password = sc.next();
		if(Employeelog(userid,password)) {
			System.out.println("\nBilling Counter - 1 --- DATA ENTRY BY EMPLOYEE\n");
			System.out.println("Employee ID: "+userid+"\n");
			while(n>=0) {
				Counter();
			}
			System.out.println("BILL PRINTING SECTION\n");
			System.out.println("Enter Client Name: ");
			String cname = sc.next();
			System.out.println("\nCLIENT NAME: "+cname);
			display();
		}else {
			System.out.println("Invalid Username or Password");
			user();
		}
	}
	public void action() throws SQLException {
		System.out.println("1 - Print Receipt\n0 - Logout");
		int n = sc.nextInt();
		if(n==1) {
			System.out.println("Receipt Printed");
			delete();
			Counter();
			display();
			return;
		}else if(n==2) {
			System.out.println("Logged out Successfully");
			user();
		}else {
			System.out.println("Invalid Choice");
		}
	}
	public void addpur(int id,String bt,String Aname,int quant,float price) throws SQLException {
		String q = "insert into purchasedetails values(?,?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(q);
		pst.setInt(1, id);
		pst.setString(2, bt);
		pst.setString(3, Aname);
		pst.setInt(4, quant);
		pst.setFloat(5, price);
		pst.executeUpdate();
		n=0;
		while(n>=0) {
			System.out.println("Enter -1 to Stop Adding: ");
			n = sc.nextInt();
			if(n>=0) {
				Counter();
			}
		}
	}
	public void display() throws SQLException {
		String q = "select *from purchasedetails";
		PreparedStatement pst = con.prepareStatement(q);
		ResultSet res = pst.executeQuery();
		while (res.next()) {
			System.out.print(res.getInt(1)+" | ");
			System.out.print(res.getString(2)+" | ");
			System.out.print(res.getString(3)+" | ");
			System.out.print(res.getInt(4)+" | ");
			System.out.print(res.getFloat(5));
			System.out.println();
		}
		action();
	}
	public void Counter() throws SQLException {
		System.out.print("Enter S.NO: ");
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
		System.out.println();
		addpur(id,bt,Aname,quant,price);
	}
	public void delete() throws SQLException {
		String q = "truncate table purchasedetails";
		PreparedStatement pst = con.prepareStatement(q);
		pst.executeUpdate();
	}
}
