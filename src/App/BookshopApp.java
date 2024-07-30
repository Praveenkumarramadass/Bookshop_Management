package App;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookshopApp extends Login{
	
	BookshopApp() throws SQLException {
		super();
	}
	public void user() throws SQLException {
		System.out.print("1 - Admin\n2 - Employee\n3 - Client\n");
		int n = sc.nextInt();
		if(n==1) {
			AdminAccess aa = new AdminAccess();
		}else if(n==2) {
			EmployeeAccess ea = new EmployeeAccess();
		}else if(n==3) {
			CustomerAccess ca = new CustomerAccess();
		}else {
			System.out.println("Invalid Choice");
		}
	}
	public int add(int id,String bt,String Aname,int quant,float price) throws SQLException {
		String q = "insert into bookdetails values(?,?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(q);
		pst.setInt(1, id);
		pst.setString(2, bt);
		pst.setString(3, Aname);
		pst.setInt(4, quant);
		pst.setFloat(5, price);
		int res = pst.executeUpdate();
		return res;
	}
	public void display() throws SQLException {
		String q = "select *from bookdetails";
		PreparedStatement pst = con.prepareStatement(q);
		ResultSet res = pst.executeQuery();
		System.out.println("\nBOOK DETAILS\n");
		while (res.next()) {
			System.out.println("ID         : "+res.getInt(1));
			System.out.println("BOOK TITLE : "+res.getString(2));
			System.out.println("AUTHOR NAME: "+res.getString(3));
			System.out.println("QUANTITY   : "+res.getInt(4));
			System.out.println("PRICE      : "+res.getFloat(5));
			System.out.println();
		}
	}
	public int edit(int id,int quant) throws SQLException{
		String q = "update bookdetails set quantity = ? where id = ?";
		PreparedStatement pst = con.prepareStatement(q);
		pst.setInt(1, quant);
		pst.setInt(2, id);
		int res = pst.executeUpdate();
		return res;
	}
	public int delete(int id) throws SQLException {
		String q = "delete from bookdetails where id=?";
		PreparedStatement pst = con.prepareStatement(q);
		pst.setInt(1, id);
		int res = pst.executeUpdate();
		return res;
	}
}
