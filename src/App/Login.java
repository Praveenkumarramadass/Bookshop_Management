package App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login{
	String url = "jdbc:mysql://localhost:3306/shop";
	String user = "root";
	String pass = "root";
	Connection con;
	
	Login() throws SQLException{
		con = DriverManager.getConnection(url,user,pass);
	}	
	Scanner sc = new Scanner(System.in);

	public boolean Adminlog(int userid,String password) throws SQLException {
		boolean bs = false;
		String q = "select*from adlogin where username=? and password=?";
		PreparedStatement pst = con.prepareStatement(q);
		pst.setInt(1, userid);
		pst.setString(2,password);
		ResultSet res = pst.executeQuery();
		while(res.next()) {
			bs =! bs;
		}
		return bs;
	}
	public boolean Employeelog(int userid,String password) throws SQLException {
		boolean bs = false;
		String q = "select*from emplogin where username=? and password=?";
		PreparedStatement pst = con.prepareStatement(q);
		pst.setInt(1, userid);
		pst.setString(2,password);
		ResultSet res = pst.executeQuery();
		while(res.next()) {
			bs =! bs;
		}
		return bs;
	}
	public boolean Clientlog(int userid,String password) throws SQLException {
		boolean bs = false;
		String q = "select*from cllogin where username=? and password=?";
		PreparedStatement pst = con.prepareStatement(q);
		pst.setInt(1, userid);
		pst.setString(2,password);
		ResultSet res = pst.executeQuery();
		while(res.next()) {
			bs =! bs;
		}
		return bs;
	}
}
