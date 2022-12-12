package com.java.e_commerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BuyPoduct extends ProductInfo {

	public static void getBuyDetails() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no.of product customer wants to buy..");
		int num = sc.nextInt();
		for (int i = 1; i <= num; i++) {

			System.out.println("no of product>> " + i);

			System.out.println("Enter productName you Want to Buy...");
			System.out.println("Enter the Id");
			int id = sc.nextInt();
			System.out.println("Enter the price");
			String price = sc.next();
			System.out.println("Enter the name");
			String name = sc.next();
			System.out.println("Enter the Quantity");
			String quantity = sc.next();

			try {
				// Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "root");

				PreparedStatement stmt = con
						.prepareStatement("insert into addcart(id,price,name,quantity)values(?,?,?,?)");

				stmt.setInt(1, id); // 1 first parameter in query.
				stmt.setString(2, price);
				stmt.setString(3, name);
				stmt.setString(4, quantity);
				int a = stmt.executeUpdate();
				System.out.println("Record is inserted.");
				con.close();

				stmt.close();

				// System.out.println(s);
			} catch (Exception e) {
				e.getMessage();
			}
		}
	}

}
/*


        

*/
