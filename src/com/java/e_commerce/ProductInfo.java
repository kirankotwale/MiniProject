package com.java.e_commerce;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.Statement;
import java.util.Scanner;

public class ProductInfo extends Login {

	public static void getProductDetails() {

		try {

			String sql = "select * from ecommerce.product";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "root");
			Statement statement = con.createStatement();
			// statement.execute(sql);
			ResultSet rs = statement.executeQuery(sql);
			System.out.println(" **Welcome To Electronic Mart** ");
			// iterate through the java resultset
						
			while (rs.next()) {
							   
				int productid = rs.getInt("productid");
				String discription = rs.getString("discription");
				String poductprice = rs.getString("poductprice");
				String productname = rs.getString("productname");
				String productquantity = rs.getString("productquantity");
				System.out.println();
				// print the results
				System.out.format("%s, %s, %s, %s,%s\n", productid, discription, poductprice, productname,
						productquantity);
				System.out.println("--------------------------------------------------------------------");
							}
				
			con.close();
			statement.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
