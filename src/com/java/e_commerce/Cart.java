package com.java.e_commerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Cart extends BuyPoduct {

	public static void getCartDetails() {

		try {
			System.out.println("**Welcome To Shopping Cart**");
			String sql = "select * from ecommerce.addcart";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "root");
			Statement statement = con.createStatement();
			// statement.execute(sql);
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");

				String price = rs.getString("price");
				String name = rs.getString("name");
				String quantity = rs.getString("quantity");
				System.out.println();
				// print the results
				System.out.format("%s, %s, %s, %s \n", id, price, name, quantity);

			}
			con.close();
			statement.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void getSumOfPrice() {
		try {
			int sum = 0;
			// Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "root");
			java.sql.Statement st = con.createStatement();
			ResultSet res = st.executeQuery("SELECT SUM(price) FROM addcart");
			while (res.next()) {
				int c = res.getInt(1);
				sum = sum + c;
			}
			System.out.println("Sum of All Product  = " + sum);

			con.close();
			st.close();

		} catch (Exception e) {
			e.getMessage();
		}

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		getUserDetails();
		getProductDetails();
		getBuyDetails();
		getCartDetails();
		getSumOfPrice();
		getLoginDetails();
	}
}
