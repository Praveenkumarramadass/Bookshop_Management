package App;

import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("WELCOME TO BOOK SHOP");
			BookshopApp BSA = new BookshopApp();
			BSA.user();
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			sc.close();
		}
	}
}
